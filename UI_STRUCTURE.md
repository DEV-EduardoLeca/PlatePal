# Estrutura de UI do PlatePal

## Estrutura de Pastas

app/src/main/java/com/example/platepal/
├── ui/
│   ├── components/          # Componentes reutilizáveis
│   │   ├── PlatePalButton.kt
│   │   ├── PlatePalTextField.kt
│   │   ├── PlatePalCard.kt
│   │   ├── PlatePalTopBar.kt
│   │   └── LoadingIndicator.kt
│   │
│   ├── screens/             # Telas do aplicativo
│   │   ├── home/
│   │   │   └── HomeScreen.kt
│   │   ├── details/
│   │   │   └── DetailsScreen.kt
│   │   └── profile/
│   │       └── ProfileScreen.kt
│   │
│   ├── navigation/          # Sistema de navegação
│   │   ├── Screen.kt        # Definição das rotas
│   │   └── NavGraph.kt      # Grafo de navegação
│   │
│   └── theme/               # Tema do app (já existente)
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
│
└── MainActivity.kt

## Componentes Criados

### 1. **PlatePalButton*
Botão customizado com estilo consistente do app
- Suporta largura total ou customizada
- Cores personalizáveis
- Estado enabled/disabled

### 2. **PlatePalTextField**
Campo de texto com validação e estilo padrão
- Suporta ícones leading e trailing
- Mensagens de erro
- Diferentes tipos de teclado
- Visual transformation (para senhas, etc.)

### 3. **PlatePalCard**
Card reutilizável para conteúdo
- Elevação customizável
- Suporta onClick opcional
- Fundo personalizável

### 4. **PlatePalTopBar**
Barra superior com navegação
- Botão de voltar opcional
- Ações customizáveis
- Estilo consistente

### 5. **LoadingIndicator**
Indicador de carregamento centralizado
- Usa as cores do tema
- Centralizado na tela

## Telas Criadas

### 1. **HomeScreen**
Tela inicial do aplicativo
- Cards de navegação
- Botões para outras telas
- Layout com LazyColumn

### 2. **DetailsScreen**
Tela de detalhes de um prato
- Informações detalhadas
- Lista de ingredientes
- Modo de preparo
- Botão de favoritar

### 3. **ProfileScreen**
Tela de perfil do usuário
- Formulário de informações
- Estatísticas
- Opções de conta

## Sistema de Navegação

### Navegação baseada em Compose Navigation
- **Screen.kt**: Define as rotas como sealed class
- **NavGraph.kt**: Configura o grafo de navegação
- Navegação type-safe
- Suporte a back stack

### Como adicionar novas telas:

1. Criar novo sealed object em `Screen.kt`:
kotlin
data object NovaTela : Screen("nova_tela")


2. Adicionar no `NavGraph.kt`:
kotlin
composable(route = Screen.NovaTela.route) {
    NovaTelaScreen(
        onNavigateBack = { navController.popBackStack() }
    )
}


3. Navegar de outra tela:
kotlin
navController.navigate(Screen.NovaTela.route)


## Boas Práticas Implementadas

1. **Separação de Responsabilidades**: Componentes, telas e navegação em pastas separadas
2. **Componentes Reutilizáveis**: Todos os componentes básicos podem ser usados em qualquer tela
3. **Navegação Type-Safe**: Usando sealed class para rotas
4. **Material Design 3**: Seguindo as guidelines do Material 3
5. **Compose Best Practices**: Usando LazyColumn, Scaffold, e outros componentes otimizados
6. **Modularidade**: Cada tela em sua própria pasta permite crescimento escalável

## Próximos Passos Sugeridos

1. Implementar ViewModels para gerenciamento de estado
2. Adicionar injeção de dependências (Hilt/Koin)
3. Implementar camada de dados e repositórios
4. Adicionar testes unitários e de UI
5. Implementar navegação com argumentos
6. Adicionar animações entre telas
7. Implementar tratamento de erros
8. Adicionar suporte a temas claro/escuro

## Como Executar

1. Sincronize o projeto com Gradle
2. Execute o app em um emulador ou dispositivo físico
3. Navegue entre as telas usando os botões e cards

## Dependências Adicionadas

```toml
navigationCompose = "2.8.5"
androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }
```
