# Exercícios de assoaciação em Java com Interface Gráfica (Swing)

Este repositório contém um projeto em Java que implementa um sistema de gerenciamento de uma empresa, utilizando a biblioteca Swing para interface gráfica. O sistema explora conceitos de **Associação**, **Composição** e **Dependência** entre classes em Java, aplicando uma estrutura orientada a objetos.

## Estrutura do Projeto

O projeto é dividido em três partes:

### Parte 1: Associação
Nesta etapa, foi implementada a associação entre as classes `Cliente` e `Empresa`.

- **Classe Cliente**: 
  - Possui os atributos `nome` e `email`.
  
- **Classe Empresa**:
  - Contém uma lista de até 5 clientes (`Cliente[] clientes`).
  - **Método `adicionarCliente`**: Recebe um nome e um email para criar um novo cliente e adicioná-lo à lista de clientes da empresa.
  - **Método `exibirClientes`**: Exibe o nome e o email de cada cliente cadastrado.

### Parte 2: Composição
Nesta etapa, foi implementada a composição entre as classes `Funcionario` e `Empresa`.

- **Classe Funcionario**:
  - Possui atributos `nome`, `cargo` e `salario`. O construtor da classe recebe esses valores ao criar o funcionário.

- **Classe Empresa**:
  - Contém uma lista de até 10 funcionários (`Funcionario[] funcionarios`).
  - **Método `adicionarFuncionario`**: Recebe o nome, cargo e salário do funcionário e o adiciona à lista.
  - **Método `exibirFuncionarios`**: Exibe o nome, cargo e salário de cada funcionário da empresa.
  - **Método `calcularFolhaSalarial`**: Calcula e exibe o total gasto com os salários dos funcionários.

### Parte 3: Dependência
Nesta etapa, foi introduzida a dependência temporária da classe `Empresa` com a classe `Calculadora`.

- **Classe Calculadora**:
  - Possui métodos para operações de soma e multiplicação.

- **Classe Empresa**:
  - **Método `calcularMediaSalarial`**: Utiliza temporariamente a classe `Calculadora` para calcular a média dos salários dos funcionários, somando os salários e dividindo pelo número de funcionários.
  - **Método `exibirMediaSalarial`**: Exibe a média salarial calculada.

## Tecnologias e Ferramentas

- **Java**
- **Swing** para criação da interface gráfica

## Como Executar o Projeto

1. Clone o repositório.
   ```bash
   git clone  https://github.com/Almile/associacao-java.git
   ```
2. Importe o projeto para sua IDE Java.
3. Compile e execute o projeto para visualizar a interface gráfica e testar as funcionalidades.
