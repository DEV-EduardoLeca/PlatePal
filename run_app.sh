#!/bin/bash

# Script para executar o PlatePal no emulador Android

echo "🚀 Iniciando PlatePal..."
echo ""

# Verificar se o emulador está rodando
DEVICES=$(adb devices | grep -v "List of devices" | grep device | wc -l)

if [ $DEVICES -eq 0 ]; then
    echo "📱 Nenhum dispositivo conectado. Iniciando emulador..."
    echo ""

    # Iniciar emulador em background
    $HOME/Library/Android/sdk/emulator/emulator -avd Pixel_7_API_35 > /dev/null 2>&1 &

    echo "⏳ Aguardando emulador iniciar (isso pode levar 1-2 minutos)..."

    # Aguardar emulador estar pronto
    adb wait-for-device

    # Aguardar o boot completo
    while [ "$(adb shell getprop sys.boot_completed 2>/dev/null | tr -d '\r')" != "1" ]; do
        echo "   Aguardando boot completo..."
        sleep 2
    done

    echo "✅ Emulador pronto!"
    echo ""
fi

# Compilar e instalar o app
echo "🔨 Compilando e instalando o app..."
./gradlew installDebug --quiet

if [ $? -eq 0 ]; then
    echo "✅ App instalado com sucesso!"
    echo ""

    # Abrir o app
    echo "📱 Abrindo o PlatePal..."
    adb shell am start -n com.example.platepal/.MainActivity > /dev/null 2>&1

    echo ""
    echo "🎉 PlatePal está rodando no emulador!"
    echo ""
    echo "💡 Dicas:"
    echo "   - Para ver logs: ./gradlew logcat"
    echo "   - Para reinstalar: ./gradlew uninstallDebug installDebug"
    echo "   - Para parar o emulador: adb emu kill"
else
    echo "❌ Erro ao compilar o app"
    exit 1
fi
