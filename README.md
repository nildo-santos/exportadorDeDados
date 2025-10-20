# Exportador de Dados de Funcionários

[cite_start]Este projeto é uma aplicação de console em Java desenvolvida como parte da Aula 05 de Programação Orientada a Objetos do curso **Java WebDeveloper - Formação Fullstack** da COTI Informática. [cite: 3, 4, 5, 6] [cite_start]A aplicação permite o cadastro de dados de um funcionário, incluindo informações pessoais, departamento e funções, e depois exporta esses dados para arquivos nos formatos **XML** e **JSON**. [cite: 612, 643]

## 🚀 Conceitos Demonstrados

O principal objetivo deste projeto é aplicar de forma prática os conceitos fundamentais da Programação Orientada a Objetos (POO) e do design de sistemas.

* [cite_start]**Programação Orientada a Objetos (POO)**: Utilização de classes, objetos, atributos e métodos para modelar o domínio do problema. [cite: 4]
* [cite_start]**Desenvolvimento em N Camadas**: O projeto é estruturado em camadas de responsabilidade (controllers, entities, repositories, etc.), uma boa prática de construção de sistemas para separar as responsabilidades do projeto. [cite: 7, 8]
* **Relacionamentos entre Classes**:
    * [cite_start]**Herança (É-UM)**: A classe `Funcionario` herda da classe `Pessoa`, representando uma relação de generalização/especialização. [cite: 79, 81, 93]
    * [cite_start]**Composição (TEM-UM / TEM-MUITOS)**: A classe `Funcionario` se compõe de um `Departamento` (relação TER-1) e uma lista de `Funcao` (relação TER-MUITOS). [cite: 80, 84, 159]
* [cite_start]**Padrão JavaBean**: As entidades (`Pessoa`, `Funcionario`, etc.) seguem o padrão com atributos privados e métodos públicos `get` e `set` para acesso e modificação. [cite: 44]
* [cite_start]**Interfaces e Polimorfismo**: É definida uma interface `FuncionarioRepository` que atua como um contrato para a exportação de dados. [cite: 546, 549] [cite_start]Classes como `FuncionarioRepositoryXml` e `FuncionarioRepositoryJson` implementam essa interface, sendo obrigadas a fornecer uma implementação para seus métodos. [cite: 569, 612, 643]
* [cite_start]**Manipulação de Arquivos**: O projeto demonstra como criar e escrever em arquivos de texto no sistema de arquivos local usando `PrintWriter` para gerar o arquivo XML. [cite: 750]
* [cite_start]**Uso de Bibliotecas Externas (JARs)**: Para a exportação em JSON, o projeto utiliza a biblioteca **Jackson**, mostrando como baixar e adicionar dependências externas ao Build Path do projeto Java. [cite: 945, 1076, 1084]

## 📂 Estrutura do Projeto

[cite_start]O código-fonte é organizado nos seguintes pacotes, seguindo o princípio do desenvolvimento em camadas: [cite: 27, 28, 29, 30, 31]

/src |-- /controllers | -- FuncionarioController.java 
Orquestra a entrada e saída de dados do usuário |-- /entities | |-- Pessoa.java 
Superclasse com dados básicos (generalização) | |-- Funcionario.java 
Subclasse com dados específicos e relacionamentos (especialização) | |-- Departamento.java 
Entidade para o relacionamento TER-1 | -- Funcao.java 
Entidade para o relacionamento TER-MUITOS |-- /interfaces | -- FuncionarioRepository.java 
Contrato que define um método para exportar dados |-- /principal | -- Main.java 
Classe com o método principal para executar a aplicação -- /repositories |-- FuncionarioRepositoryXml.java 
Implementação que exporta os dados para um arquivo XML -- FuncionarioRepositoryJson.java
Implementação que exporta os dados para um arquivo JSON

## 🛠️ Tecnologias Utilizadas

* **Java SE 21** [cite: 23, 25]
* **Jackson Databind, Core & Annotations** (Biblioteca para manipulação de JSON) [cite: 946, 989, 1032]

## ⚙️ Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/nildo-santos/exportadorDeDados.git](https://github.com/nildo-santos/exportadorDeDados.git)
    ```
2.  **Abra o projeto** em sua IDE Java preferida (por exemplo, Eclipse). [cite: 16]

3.  **Adicione as bibliotecas Jackson:**
    * Faça o download dos arquivos `.jar` das seguintes bibliotecas no [MVN Repository](https://mvnrepository.com/): [cite: 945]
        * `jackson-databind` [cite: 946]
        * `jackson-core` [cite: 989]
        * `jackson-annotations` [cite: 1032]
    * Adicione os arquivos `.jar` ao Build Path do projeto. No Eclipse, clique com o botão direito no projeto > `Build Path` > `Configure Build Path...` > Aba `Libraries` > `Classpath` > `Add External JARs...`. [cite: 1084, 1131]

4.  **Execute a aplicação:**
    * Encontre a classe `Main.java` no pacote `principal`. [cite: 396]
    * Execute o método `main`. [cite: 465]

5.  **Interaja com o console:**
    * O programa solicitará que você insira os dados do funcionário, como nome, CPF, salário, departamento e uma ou mais funções. [cite: 331, 341, 343, 346, 348, 354, 367]

6.  **Verifique os arquivos de saída:**
    * Após o cadastro, os arquivos `funcionario_[id].xml` e `funcionario_[id].json` serão gerados no diretório `c:\temp\` (no Windows). [cite: 750, 1190] A mensagem "ARQUIVO XML GERADO COM SUCESSO!" e "ARQUIVO JSON GERADO COM SUCESSO!" será exibida no console. [cite: 856, 1274]

## 📄 Exemplo de Saída

<img width="1720" height="1372" alt="image" src="https://github.com/user-attachments/assets/bf80d007-2294-405a-8fcf-04e77b27f0a9" />


### XML
```xml
<funcionario>
    <id>9523ba95-0e04-4fbd-9780-11bfa2990d8b</id>
    <nome>Ana Maria</nome>
    <cpf>32145698700</cpf>
    <matricula>2025-002</matricula>
    <salario>5000.0</salario>
    <departamento>
        <id>afbc4bf9-dca0-4d80-955b-14da0486641f</id>
        <nome>Recursos Humanos</nome>
    </departamento>
    <funcoes>
        <funcao>
            <id>f70d1dcd-5a79-4144-9908-aa89d0f66c6b</id>
            <nome>Gerente de RH</nome>
        </funcao>
    </funcoes>
</funcionario>
```

## JSON
```
{
  "id": "4f5c5185-6f7c-4800-be2c-dfd7a4da27b8",
  "nome": "Ana Maria",
  "cpf": "12365478900",
  "matricula": "2025-002",
  "salario": 5000,
  "departamento": {
    "id": "16fc70ff-4ad9-45d7-9a0c-08e6ee60602a",
    "nome": "Recursos Humanos"
  },
  "funcoes": [
    {
      "id": "2a295ef4-eef1-476c-b9c9-272bfdfd2299",
     "nome": "Gerente de RH"
    }
  ]
}
