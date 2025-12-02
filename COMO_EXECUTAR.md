# 🚀 Como Executar o PlatePal

## ✅ Problema Resolvido

O emulador Android está funcionando! O app PlatePal foi instalado e está rodando.

---

## 📱 Status Atual

- ✅ **Emulador:** Pixel 7 API 35 (Android 15)
- ✅ **App instalado:** PlatePal v1.0
- ✅ **Status:** Rodando sem erros

---

## 🎯 3 Formas de Executar o App

### 1️⃣ **Forma Rápida (Script Automático)** ⭐ RECOMENDADO

```bash
./run_app.sh
```

Este script faz tudo automaticamente:
- Verifica se o emulador está rodando
- Inicia o emulador se necessário
- Compila o app
- Instala no emulador
- Abre o app

---

### 2️⃣ **Via Gradle (Manual)**

**Passo 1:** Iniciar o emulador (se ainda não estiver rodando)
```bash
$HOME/Library/Android/sdk/emulator/emulator -avd Pixel_7_API_35 &
```

**Passo 2:** Aguardar emulador iniciar (1-2 minutos)
```bash
adb wait-for-device
```

**Passo 3:** Instalar o app
```bash
./gradlew installDebug
```

**Passo 4:** Abrir o app
```bash
adb shell am start -n com.example.platepal/.MainActivity
```

---

### 3️⃣ **Via Android Studio**

1. Abra o projeto no Android Studio
2. Aguarde a sincronização do Gradle terminar
3. Clique no botão **"Run"** (▶️) na barra superior
4. Selecione o emulador **Pixel_7_API_35**
5. Aguarde o app abrir

---

## 🔧 Comandos Úteis

### Ver dispositivos conectados
```bash
adb devices
```

### Ver logs em tempo real
```bash
adb logcat | grep -E "PlatePal"
```

### Limpar logs
```bash
adb logcat -c
```

### Reinstalar o app
```bash
./gradlew uninstallDebug installDebug
```

### Parar o emulador
```bash
adb emu kill
```

### Limpar e recompilar
```bash
./gradlew clean build
```

---

## 🐛 Solução de Problemas

### Problema: Emulador não inicia

**Solução 1:** Verificar se há outro emulador rodando
```bash
adb devices
adb emu kill  # Mata todos os emuladores
```

**Solução 2:** Reiniciar o ADB
```bash
adb kill-server
adb start-server
```

---

### Problema: App não instala

**Solução:** Desinstalar versão antiga e instalar novamente
```bash
adb uninstall com.example.platepal
./gradlew installDebug
```

---

### Problema: App trava ou não abre

**Solução 1:** Ver os logs
```bash
adb logcat | grep -E "(PlatePal|FATAL|AndroidRuntime)"
```

**Solução 2:** Limpar dados do app
```bash
adb shell pm clear com.example.platepal
```

**Solução 3:** Reinstalar
```bash
./gradlew uninstallDebug installDebug
```

---

### Problema: Emulador muito lento

**Solução 1:** Aumentar RAM do emulador
- Abrir Android Studio
- Tools → Device Manager
- Editar Pixel_7_API_35
- Aumentar RAM para 4GB+

**Solução 2:** Habilitar aceleração de hardware
```bash
# Verificar se KVM/HAXM está habilitado
$HOME/Library/Android/sdk/emulator/emulator -accel-check
```

---

## 📊 Informações do Emulador

**Nome:** Pixel_7_API_35
**Sistema:** Android 15 (API 35)
**Resolução:** 1080x2400
**Densidade:** 420dpi

---

## 🎨 Preview do App

Ao abrir o app, você verá:

1. **🌱 Ícone de planta** no topo
2. **🔍 Barra de pesquisa** com microfone
3. **Botões de categoria:**
   - 🥩 Carne
   - 🐟 Peixe
   - 🍗 Frango
4. **"Top 10 Receitas da Semana"** (título)
5. **Cards de receitas:**
   - Frango assado - 25Min, 5⭐, 450 Kcal
   - Peixe assado - 20Min, 4⭐, 400 Kcal
   - Carne assada - 30Min, 5⭐, 500 Kcal
6. **Bottom navigation bar** (5 ícones)

---

## 🔄 Hot Reload (Recarregar sem fechar o app)

**NÃO disponível** - Este é um app nativo Android com Jetpack Compose.

Para ver mudanças:
1. Feche o app no emulador
2. Execute: `./gradlew installDebug`
3. Abra o app novamente

**Tip:** Para desenvolvimento mais rápido, use o Live Edit do Android Studio (Android Studio Flamingo+)

---

## 📝 Notas Importantes

### ⚠️ VSCode Launch Configuration

O arquivo `.vscode/launch.json` estava configurado para Chrome, não para Android. Para rodar o app Android:

**❌ NÃO USE:** Botão "Run" do VSCode
**✅ USE:** Um dos métodos acima (script ou Gradle)

### 🎯 Android Studio é Recomendado

Para desenvolvimento Android, o **Android Studio** oferece:
- Live Edit / Hot Reload
- Layout Inspector visual
- Profiler de performance
- Debugger integrado
- Emulador integrado

---

## 🚀 Próximos Passos

1. **Testar todas as funcionalidades:**
   - [ ] Scroll na lista de receitas
   - [ ] Clique nos cards de receitas
   - [ ] Teste a barra de pesquisa
   - [ ] Navegação na bottom bar

2. **Verificar responsividade:**
   - [ ] Modo retrato
   - [ ] Modo paisagem
   - [ ] Diferentes tamanhos de tela

3. **Performance:**
   - [ ] Scroll suave
   - [ ] Sem lags
   - [ ] Tempo de abertura < 2s

---

## 📞 Comandos de Emergência

### Parar tudo e recomeçar
```bash
# Matar emulador
adb emu kill

# Limpar projeto
./gradlew clean

# Recompilar
./gradlew build

# Reiniciar emulador
$HOME/Library/Android/sdk/emulator/emulator -avd Pixel_7_API_35 &

# Aguardar
adb wait-for-device

# Instalar
./gradlew installDebug

# Abrir
adb shell am start -n com.example.platepal/.MainActivity
```

Ou simplesmente:
```bash
./run_app.sh
```

---

## ✅ Checklist de Funcionamento

- [x] Emulador inicia
- [x] App compila sem erros
- [x] App instala no emulador
- [x] App abre sem crashes
- [x] Interface aparece corretamente
- [ ] Navegação funciona (a implementar)
- [ ] Botões respondem (a implementar)

---

**Última atualização:** 02/12/2025
**Status:** ✅ FUNCIONANDO
