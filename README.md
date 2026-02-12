# 🧩 Sudoku - Java Implementation

> Implementação de um jogo de Sudoku em Java com modelagem orientada a
> objetos.

![Java](https://img.shields.io/badge/Java-17+-orange)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-MIT-blue)

------------------------------------------------------------------------

## 📌 Sobre o Projeto

Este projeto é uma implementação de **Sudoku em Java**, desenvolvida com
foco em:

-   ✔️ Programação Orientada a Objetos
-   ✔️ Organização de responsabilidades
-   ✔️ Clareza de modelagem de domínio
-   ✔️ Estrutura simples e didática

O sistema permite representar e validar um tabuleiro de Sudoku
utilizando classes bem definidas.

------------------------------------------------------------------------

## 🏗️ Estrutura do Projeto

    src/br/com/dio
    │
    ├── model
    │   ├── Board.java
    │   ├── Space.java
    │   ├── GameStatusEnum.java
    │
    ├── util
    │   ├── BoardTemplate.java
    │
    └── Main.java

### 📦 Descrição das Classes

-   **Board.java**\
    Representa o tabuleiro do Sudoku e centraliza as regras do jogo.

-   **Space.java**\
    Representa uma posição individual do tabuleiro.

-   **GameStatusEnum.java**\
    Enumeração responsável por representar o estado atual do jogo.

-   **BoardTemplate.java**\
    Classe utilitária para criação/configuração inicial do tabuleiro.

-   **Main.java**\
    Classe principal responsável por iniciar a aplicação.

------------------------------------------------------------------------

## 🧠 Conceitos Aplicados

-   Programação Orientada a Objetos
-   Encapsulamento
-   Separação de responsabilidades
-   Modelagem de domínio
-   Enum para controle de estado

------------------------------------------------------------------------

## ▶️ Como Executar

### 🔧 Pré-requisitos

-   Java 17+ (ou versão compatível)
-   IDE como IntelliJ / Eclipse (opcional)

### ▶️ Executando via terminal

Compile o projeto:

``` bash
javac src/br/com/dio/**/*.java
```

Execute a aplicação:

``` bash
java br.com.dio.Main
```

Ou simplesmente execute a classe `Main.java` pela IDE.

------------------------------------------------------------------------

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para:

-   Praticar lógica de programação
-   Exercitar modelagem orientada a objetos
-   Compreender regras de validação do Sudoku
-   Servir como projeto educacional / portfólio

------------------------------------------------------------------------

## 🚀 Possíveis Evoluções

-   🔹 Implementar algoritmo de resolução automática (Backtracking)
-   🔹 Criar interface gráfica (JavaFX / Swing)
-   🔹 Implementar testes unitários (JUnit)
-   🔹 Criar versão web
-   🔹 Adicionar níveis de dificuldade

------------------------------------------------------------------------

## 🤝 Contribuição

Contribuições são bem-vindas!

1.  Fork o projeto
2.  Crie uma branch (`feature/minha-feature`)
3.  Commit suas alterações
4.  Abra um Pull Request

------------------------------------------------------------------------

## 📄 Licença

Este projeto está sob a licença MIT.
