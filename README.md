# 🃏 Triple Triad

Implementação em Java do clássico jogo de cartas **Triple Triad**, inspirado em Final Fantasy VIII.

## 🎓 Sobre o projeto

Este projeto foi desenvolvido como parte das atividades acadêmicas da disciplina **Paradigmas de Programação**, do curso de **Bacharelado em Ciência da Computação**.

O objetivo foi aplicar na prática os conceitos estudados durante a disciplina, utilizando Java para desenvolver a lógica do jogo, estruturar suas funcionalidades e trabalhar com os princípios da programação orientada a objetos.

O jogo simula partidas entre dois jogadores, utilizando um tabuleiro 3x3, cartas com diferentes atributos e regras especiais de captura.

## 🎮 Como funciona

Cada jogador recebe 5 cartas aleatórias e deve posicioná-las estrategicamente no tabuleiro, tentando capturar as cartas do adversário.

A partida termina quando todas as 9 casas do tabuleiro estão preenchidas. O jogador com mais pontos vence.

## ⚔️ Funcionalidades

- Partida entre dois jogadores.
- Distribuição aleatória de cartas.
- Catálogo de cartas.
- Tabuleiro 3x3 via terminal.
- Sistema de captura baseado nos valores das cartas.
- Contagem de pontos.
- Identificação dos jogadores no tabuleiro.
- Regras especiais de captura.

## ✨ Regras especiais

- **Plus:** permite capturar cartas por meio de somas iguais entre valores de cartas adjacentes.
- **Same:** permite capturar cartas quando dois ou mais valores adjacentes são iguais.
- **Ascension:** cartas do mesmo elemento recebem bônus nos atributos quando uma carta elemental é posicionada no tabuleiro.

## 🛠️ Tecnologias e conceitos utilizados

- Java
- Programação Orientada a Objetos (POO)
- Collections (List, Map e Set)
- Matrizes
- Enum
- Random
- Scanner

## 📂 Estrutura do projeto

```text
tripleTriad/
└── src/
    ├── enums/
    ├── main/
    ├── models/
    └── module-info.java
```

## ▶️ Como executar

### Pré-requisitos

- Java JDK instalado.
- IDE Java (Eclipse, IntelliJ IDEA ou VS Code) ou terminal configurado.

### Executando pela IDE

1. Clone o repositório.
2. Importe o projeto como um projeto Java.
3. Localize a classe `Main.java`, dentro do pacote `main`.
4. Execute o método `main`.

## 📚 Contexto acadêmico

**Curso:** Bacharelado em Ciência da Computação  
**Disciplina:** Paradigmas de Programação  
**Linguagem:** Java  
**Projeto:** Desenvolvimento de uma implementação do jogo Triple Triad.

---

Desenvolvido para fins acadêmicos e de aprendizado, colocando em prática os conceitos de programação estudados durante a graduação.