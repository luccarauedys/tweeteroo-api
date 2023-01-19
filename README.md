## 📝 Descrição

API do Tweeteroo, mini clone do Twitter. Projeto construído com o intuito de testar conhecimentos adquiridos na segunda semana do curso de Java com Spring Boot.

## 🚀 Tecnologias

- [Java](https://www.java.com)
- [SpringBoot](https://spring.io/projects/spring-boot)

## 📦 Instalação

Para clonar o repositório, utilize um dos comandos abaixo:

```bash
$ git clone https://github.com/luccarauedys/tweeteroo-api

# OU

$ git clone git@github.com:luccarauedys/tweeteroo-api.git
```

## 📌 Funcionalidades

- Criar usuários;
- Criar tweets;
- Buscar tweets com paginação (limite de 5 tweets por página);
- Buscar todos os tweets de um usuário específico;

## 🔀 Rotas

- **POST** /api/users

  - O body da request deve ter o seguinte formato:
    ```json
    {
      "username": "scoobydoo",
      "avatar": "https://64.media.tumblr.com/b34bea474a465262543616113324ed1a/313038784a1dcba5-75/s640x960/4d2d099944ba5aa480a5abe48555d794c64078e1.png"
    }
    ```

- **POST** /api/tweets

  - O body da request deve ter o seguinte formato:

    ```json
    {
      "username": "scoobydoo",
      "tweet": "where's my scooby snack?"
    }
    ```

- **GET** /api/tweets OU /api/tweets?page=0

  - Paginação começa pelo índice zero (0 = primeira página, 1 = segunda página etc);
  - Se não passar o parâmetro "page" ele mostra por padrão a primeira página;
  - Retorna os 5 últimos tweets;
  - Formato da resposta:

    ```json
    [
      {
        "username": "scoobydoo",
        "avatar": "https://64.media.tumblr.com/b34bea474a465262543616113324ed1a/313038784a1dcba5-75/s640x960/4d2d099944ba5aa480a5abe48555d794c64078e1.png",
        "tweet": "scooby dooby doo"
      }
    ]
    ```

- **GET** /api/tweets/USERNAME

  - Substitua USERNAME pelo nome do usuário;
  - Retorna todos os tweets publicados do usuário recebido por parâmetro de rota;
  - Formato da resposta:

    ```json
    [
      {
        "username": "scoobydoo",
        "avatar": "https://64.media.tumblr.com/b34bea474a465262543616113324ed1a/313038784a1dcba5-75/s640x960/4d2d099944ba5aa480a5abe48555d794c64078e1.png",
        "tweet": "scooby dooby doo"
      }
    ]
    ```
