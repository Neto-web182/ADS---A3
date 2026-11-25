# Sistema de Gestão de Pizzaria (Projeto A3: Atendimento automatizado de uma pizzaria)

Este projeto é uma aplicação desenvolvida em Java via console para o gerenciamento de uma pizzaria. O sistema permite realizar pedidos, administrar o cardápio, controlar o acesso por perfil de usuário e acompanhar o faturamento diário.

O trabalho foi desenvolvido para a avaliação A3 da disciplina de Algoritmos e Programação (2026.2), aplicando na prática conceitos de Programação Orientada a Objetos (POO), estruturas condicionais, laços de repetição, listas (`ArrayList`) e tratamento de erros.

------------------------------------------------------------------------------------------------------------------------------------------------
## Problema que o Sistema Resolve

Muitas pizzarias pequenas acabam controlando pedidos, taxas de entrega e fechamento de caixa de forma manual, o que gera demora no atendimento e erros nos cálculos.

O objetivo deste sistema é organizar esse processo no terminal, separando o que cada pessoa pode fazer: o cliente consegue montar seu pedido sozinho, o gerente mantém o cardápio atualizado e o dono acompanha os resultados financeiros do dia.

---

## Integrantes da Equipe

* Desenvolvedor principal: João Moura da Fonseca Neto
* Desenvolvedor secundário: João Gabriel de Sousa Marques
* Leandro Luis Maciel Xavier dos Santos
* Dayvid Daniel Duarte Ramos
* Mário Lúcio Costa de Oliveira
* Raied Lucas de Sousa Lins

-----------------------------------------------------------------------------------------------------------------------------------------------

## Perfis de Acesso e Permissões

O sistema conta com três perfis diferentes. Cada um tem seu próprio menu e só acessa as funções permitidas para a sua função:


### 1. Cliente

* **Acesso:** Livre, sem necessidade de senha. Basta informar o nome ao entrar.
* **O que pode fazer:**
  * Consultar o cardápio com os preços e descrições.
  * Fazer pedidos com um ou mais itens.
  * Escolher entre retirada no local ou entrega (com cálculo automático de taxa para os bairros Planalto ou Pitimbu).
  * Conferir o resumo do pedido, confirmar a compra e informar se precisa de troco.
* **Restrições:** Não consegue alterar o cardápio nem acessar os relatórios do estabelecimento.


### 2. Gerente

* **Acesso:** Exige cadastro prévio e login com usuário e senha.
* **O que pode fazer:**
  * Visualizar o cardápio atual.
  * Cadastrar novos produtos (nome, descrição e valor).
  * Alterar produtos já cadastrados usando a posição do item na lista.
  * Remover um item específico ou limpar todo o cardápio.
* **Restrições:** Não tem acesso ao faturamento, ao histórico de vendas e não pode mudar o nome da pizzaria.


### 3. Dono do Restaurante

* **Acesso:** Exige cadastro prévio e login com usuário e senha.
* **O que pode fazer:**
  * Ver o faturamento total do dia.
  * Consultar o histórico de vendas (clientes atendidos, itens comprados e total arrecadado com entregas).
  * Visualizar o usuário e a senha cadastrados do gerente, o que permite a ele acessar também a área do gerente para administrar o cardápio caso precise.
  * Alterar o nome da pizzaria que aparece para os clientes.
* **Restrições:** No seu menu próprio, o foco é apenas administrativo e financeiro, mas possui acesso indireto às funções de gerência por ter visibilidade das credenciais do gerente.


-----------------------------------------------------------------------------------------------------------------------------------------------
## Principais Funcionalidades

* **Gerenciamento de Cardápio:** Cadastro, listagem, edição e remoção de produtos usando `ArrayList`.
* **Fluxo de Pedidos:**
  * Impede que o cliente faça pedidos caso o cardápio ainda esteja vazio.
  * Calcula o subtotal dos produtos, soma a taxa de entrega conforme o bairro (`R$ 10,00` para Planalto e `R$ 15,00` para Pitimbu) 
    e exibe o   valor final.
  * Calcula o troco e avisa caso o valor informado pelo cliente seja menor que o total do pedido.
* **Validação de Entradas:** Uso de `try-catch` para impedir que o programa pare caso o usuário digite letras onde deveria digitar números.

------------------------------------------------------------------------------------------------------------------------------------------------

## Estrutura das Principais Classes

Todas as classes estão dentro do pacote `projeto.src`:

* **`InterfaceConsole.java`**: Classe principal (`main`) que controla os menus, a navegação entre os perfis e a interação com o usuário no terminal.
* **`ControleAcesso.java`**: Cuida do cadastro e da validação de login (usuário e senha) do Gerente e do Dono.
* **`SistemaCardapio.java`**: Guarda as listas de produtos, descrições e preços, além dos métodos para listar, adicionar, alterar, remover e limpar o cardápio.
* **`SistemaPedido.java`**: Controla os itens escolhidos pelo cliente, calcula a taxa de entrega, mostra o resumo do pedido e faz o cálculo do troco.
* **`SistemaDoDono.java`**: Armazena o histórico dos pedidos confirmados, soma o faturamento e as taxas de entrega, exibe as credenciais do gerente e permite mudar o nome da pizzaria.
* **`LeitorEntrada.java`**: Classe auxiliar que trata a leitura de números inteiros e decimais via `Scanner`, evitando erros de digitação.

-----------------------------------------------------------------------------------------------------------------------------------------------

## Tecnologias Utilizadas

* **Java** (JDK 17 ou superior)
* **Programação Orientada a Objetos (POO)**
* **Java Collections (`ArrayList`)**
* **Scanner e Tratamento de Exceções (`InputMismatchException`)**

-----------------------------------------------------------------------------------------------------------------------------------------------


## Requisitos para Execução

* Ter o **JDK 15 ou superior** instalado (necessário por conta do uso de blocos de texto `"""` no código).
* Um terminal (CMD, PowerShell, terminal do Linux/Mac ou o terminal da própria IDE).


-----------------------------------------------------------------------------------------------------------------------------------------------
## Como Compilar e Executar

1. Baixe ou clone este repositório para o seu computador:

```bash
git clone https://github.com/Neto-web182/ADS---A3.git
```

2. Abra o terminal na pasta raiz do projeto (a pasta que contém o diretório `projeto/src`):

```bash
cd ADS---A3
```

3. Compile os arquivos Java:

```bash
javac projeto/src/*.java
```

4. Execute o programa:

```bash
java projeto.src.InterfaceConsole
```

-----------------------------------------------------------------------------------------------------------------------------------------------

## Roteiro para Testar os Perfis

Para demonstrar o funcionamento completo do sistema e das permissões, siga esta ordem:

1. **Testar o bloqueio do Cliente:** Entre na opção `1` (Cliente), digite um nome e tente fazer um pedido (`2`). O sistema vai avisar que o cardápio está vazio. Volte ao menu inicial (`0`).
2. **Cadastrar o Gerente e criar o cardápio:** Entre na opção `2` (Gerente), faça o cadastro na opção `1` e depois o login na opção `2`. Adicione pelo menos um produto no cardápio (opção `2`) e saia até o menu principal.
3. **Fazer um pedido:** Entre novamente como Cliente (`1`), faça um pedido (`2`), escolha o produto cadastrado, selecione `entrega`, informe o bairro `planalto` e um endereço. Confirme o pedido com `sim` e teste o cálculo de troco.
4. **Conferir relatórios como Dono:** Volte ao menu inicial, entre na opção `3` (Dono), faça o cadastro (`1`) e o login (`2`). Acesse o faturamento do dia (`1`) e o histórico (`2`) para ver o pedido registrado e as credenciais do gerente.