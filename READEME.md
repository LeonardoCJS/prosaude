# Monitoramento de Saúde – API Spring Boot

## Descrição

API RESTful para monitoramento da saúde física e mental de funcionários no ambiente de trabalho, integrando sensores inteligentes e painel web. Permite o registro e consulta de batimentos cardíacos, tempo sentado, vinculação de pulseiras e fornece dados para prevenção de burnout, promoção de saúde e gestão ocupacional. A autenticação é totalmente segura via JWT.

---

## Funcionalidades

- Cadastro, alteração, listagem e deleção de **Funcionários**
- Vinculação, alteração e consulta de **Pulseiras inteligentes**
- Registro e leitura paginada de **Batimentos cardíacos**
- Registro e consulta de **Tempo sentado**
- **Autenticação JWT** (login seguro, token nos headers)
- **Validação automática** com Bean Validation
- **Paginação** e ordenação nos endpoints
- **Documentação Swagger/OpenAPI** interativa
- **Pronto para deploy na nuvem** (Heroku, Render, Railway, AWS, etc)

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (dev) ou banco relacional à escolha
- Lombok
- Bean Validation (Jakarta Validation)
- Springdoc OpenAPI (Swagger UI)
- Spring Security + JWT (io.jsonwebtoken)
- Maven

---

## Como Executar

1. **Clone o projeto:**
   git clone https://github.com/seu-usuario/monitoramento-saude.git
   cd monitoramento-saude

2. **Ajuste o arquivo `application.yml` se desejar**  
   (Uso padrão: banco H2 em memória para testes locais)

3. **Execute o sistema:**
   ./mvnw spring-boot:run


4. **Acesse a documentação Swagger:**  
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Autenticação JWT

1. Cadastre manualmente um usuário na tabela `usuario` do banco (senha deve ser criptografada com BCrypt).
2. Faça login via POST em `/auth/login`:
{
   "username": "usuario",
   "password": "suaSenha"
   }

O retorno será um token JWT.

3. Para consumir endpoints protegidos, adicione o header:Authorization: Bearer SEU_TOKEN_AQUI


---

## Principais Endpoints

- **POST /auth/login** — Autenticação JWT
- **GET/POST/PUT/DELETE /funcionarios** — CRUD completo para funcionários (paginação disponível)
- **GET/POST/PUT/DELETE /pulseiras** — Gerenciamento de pulseiras
- **POST/GET /batimentos** — Registro e consulta de batimentos (com paginação e filtro por funcionário)
- **POST/GET /temposentado** — Registro e consulta do tempo sentado

Todos os endpoints, exceto `/auth/login` e Swagger, exigem token JWT válido.

---

## Exemplos de Uso com Swagger

- Acesse o Swagger UI
- Clique em “Authorize” e cole seu token JWT dessa forma:
  Bearer SEU_TOKEN_AQUI

- Simule requisições protegidas diretamente pela interface.

---

## Estrutura

- `domains/` — Entidades JPA
- `dtos/` — Data Transfer Objects request/response
- `repositories/` — Interfaces Spring Data
- `services/` — Regras de negócio
- `gateways/` — REST Controllers
- `security/` — JWT e segurança
- `exceptions/` — Tratamento global de erros
- `resources/` — application.yml e assets

---


