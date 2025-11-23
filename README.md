# Monitoramento de Saúde – API Spring Boot

## Descrição

API RESTful desenvolvida em Java com Spring Boot para monitoramento contínuo da saúde de funcionários. A solução é configurada para rodar com múltiplos ambientes de banco de dados usando Spring Profiles: **Oracle** para desenvolvimento/produção (perfil `dev`) e **H2 em memória** para testes locais (perfil `local`). O sistema possui autenticação segura via JWT e documentação completa com Swagger.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.x
- Spring Security 6.x
- Spring Data JPA
- Oracle Database (para perfil 'dev')
- H2 Database (para perfil 'local')
- JWT (io.jsonwebtoken 0.11.5)
- Lombok
- Maven

---

## Como Executar o Projeto (com Perfis de Ambiente)

O projeto usa Spring Profiles para alternar entre o banco de dados H2 (local) e Oracle (dev). O perfil padrão é `local`.

### Opção 1: Executando com o Perfil `local` (H2 Database) - PADRÃO

Este perfil usa um banco de dados em memória e não requer nenhuma configuração externa.

1.  **Execute a aplicação via terminal (sem argumentos extras):**
    ```
    ./mvnw spring-boot:run
    ```
    Como `local` é o perfil padrão definido no `application.yml`, ele será ativado automaticamente.

2.  **Para executar via IDE (IntelliJ, Eclipse):**
    Apenas rode a aplicação normalmente. Não é necessário configurar nenhuma variável ou opção.

3.  **Acessando o Console do H2:**
    Com a aplicação rodando, acesse `http://localhost:8080/h2-console` para visualizar o banco de dados em memória. Use as credenciais definidas em `application-local.yml` (URL: `jdbc:h2:mem:java-advanced-db`, user: `sa`, password: em branco).

### Opção 2: Executando com o Perfil `dev` (Oracle Database)

Este perfil requer a configuração de variáveis de ambiente para as credenciais do banco.

1.  **Exporte as Variáveis de Ambiente no seu terminal:**
    Antes de executar, configure as seguintes variáveis com suas credenciais do Oracle:
    ```
    # Para Linux/macOS
    export PROFILE=dev
    export DATABASE_USER=SEU_USUARIO_ORACLE
    export DATABASE_PASSWORD=SUA_SENHA_ORACLE

    # Para Windows (PowerShell)
    $env:PROFILE="dev"
    $env:DATABASE_USER="SEU_USUARIO_ORACLE"
    $env:DATABASE_PASSWORD="SUA_SENHA_ORACLE"
    ```

2.  **Execute a aplicação:**
    Após configurar as variáveis, rode o comando normal:
    ```
    ./mvnw spring-boot:run
    ```
    A aplicação detectará `PROFILE=dev` e usará o `application-dev.yml`.

3.  **Para executar via IDE:**
    - Vá em "Edit Run/Debug Configurations".
    - Na seção "Environment variables", adicione as três variáveis: `PROFILE`, `DATABASE_USER` e `DATABASE_PASSWORD` com seus respectivos valores.
    - Rode a aplicação.

---

## Autenticação e Acesso à API

O fluxo de autenticação é o mesmo para ambos os perfis:

1.  **Registre um Usuário:** `POST /auth/register`
2.  **Faça o Login:** `POST /auth/login` para obter o token JWT.
3.  **Acesse Endpoints Protegidos:** Use o token no header `Authorization: Bearer SEU_TOKEN...`

### 1. Registre um Novo Usuário

Faça uma requisição POST para `/auth/register` com o seguinte corpo (body):

{
"username": "seu_usuario",
"password": "sua_senha_forte"
}

### 2. Faça o Login

Faça uma requisição POST para `/auth/login` com as mesmas credenciais:

{
"username": "seu_usuario",
"password": "sua_senha_forte"
}

- A resposta será um token JWT.

### 3. Acesse Endpoints Protegidos

Para as outras requisições, adicione o token no cabeçalho `Authorization`:

Authorization: Bearer SEU_TOKEN_JWT...

---

## Principais Endpoints

- POST /auth/register – Cria um novo usuário.
- POST /auth/login – Autentica um usuário e retorna um token JWT.
- GET /funcionarios – Lista todos os funcionários (requer token).
- POST /funcionarios – Cria um novo funcionário (requer token).
- ...e todos os outros endpoints de `pulseiras`, `batimentos`, `temposentado`.

---
