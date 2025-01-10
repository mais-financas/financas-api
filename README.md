# Mais Finanças API

Repositório do serviço de gerenciamento de despesas do projeto [Mais Finanças](https://github.com/mais-financas).

## Implementações Técnicas

- Arquitetura em Camadas
- Migrations de Banco de Dados
- Docker para conteinerização da aplicação
- Configuração de perfis para execução local e em ambiente de produção

A aplicação utiliza como exemplo endpoints para o controle de despesas pessoais.

## Tecnologias e Ferramentas

A PoC foi desenvolvida utilizando as seguintes tecnologias:

- Linguagem de Programação: Java
- Framework: Spring Boot
- Banco de Dados: PostgreSQL
- Ferramentas: Git, Docker, Flyway

## Executando a aplicação

## Pré-Requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados em seu ambiente de desenvolvimento:

- **JDK (Java Development Kit)**: É necessário ter o JDK 21 ou superior instalado para compilar e executar o projeto.
- **Docker**: É necessário possuir o docker instalado para executar a aplicação em ambiente local e banco de dados.

### Clone o projeto

```shell
git clone https://github.com/gustxvo/mais-financas-api.git
```

### Entre no diretório do projeto

```shell
cd poc-financas-api
```

### Execute o comando

```shell
./gradlew bootRun
```

## API Reference

Os principais endpoints para verificação do projeto são os seguintes.

### Adicionar Gestor

Adiciona um gestor ao sistema.

```http
POST /api/gestores
```

#### Corpo da requisição - Exemplo

```json
{
  "nome": "Exemplo",
  "email": "email@exemplo.com",
  "senha": "senha123"
}
```

#### Resposta do Servidor

- Código de status: 201 CREATED
- Formato da resposta: application/json
- Exemplo de resposta:

```json
{
  "id": "39b4fe9e-9e3b-4cdb-b7d5-53b894f0798e",
  "nome": "Exemplo",
  "email": "email@exemplo.com"
}
```

---

### Listar Gestores

```http
GET /api/gestores
```

Lista os gestores do sistema.
#### Resposta do Servidor

- Código de status: 200 OK
- Formato da resposta: application/json
- Exemplo de resposta:

```json
[
  {
    "id": "08afeda9-a1bc-4649-aa04-0c2ca6899ca2",
    "nome": "Exemplo",
    "email": "email@exemplo.com"
  },
  {
    "id": "39b4fe9e-9e3b-4cdb-b7d5-53b894f0798e",
    "nome": "fulano",
    "email": "fulano@exemplo.com"
  }
]
```

---

### Adicionar Despesa

```http
POST /api/gestores/{id}/despesas
```

| Parâmetro | Descrição              |
|:----------|:-----------------------|
| `id`      | id do gestor procurado |

Adiciona uma despesa ao gestor especificado.


#### Corpo da requisição - Exemplo

```json
{
  "nome": "Netflix",
  "valor": 39.90
}
```

#### Resposta do Servidor

- Código de status: 201 CREATED
- Formato da resposta: application/json
- Exemplo de resposta:

```json
{
  "id": 1,
  "nome": "Netflix",
  "valor": 39.90,
  "gestor_id": "39b4fe9e-9e3b-4cdb-b7d5-53b894f0798e"
}
```

---

### Listar Despesas de um Gestor

Retorna as despesas do gestor especificado.

```http
GET /api/gestores/{id}/despesas
```

| Parâmetro | Descrição              |
|:----------|:-----------------------|
| `id`      | id do gestor procurado |

#### Resposta do Servidor

- Código de status: 200 OK
- Formato da resposta: application/json
- Exemplo de resposta:

```json
[
  {
    "id": 1,
    "nome": "Netflix",
    "valor": 39.90,
    "gestor_id": "39b4fe9e-9e3b-4cdb-b7d5-53b894f0798e"
  },
  {
    "id": 2,
    "nome": "Cinema",
    "valor": 28.50,
    "gestor_id": "39b4fe9e-9e3b-4cdb-b7d5-53b894f0798e"
  }
]
```
