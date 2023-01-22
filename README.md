# Link Shortener

## Índice :memo:
#### ✏️ [Sobre](https://github.com/Biguelini/Link-Shortener#sobre)
#### 🚀 [Objetivos](https://github.com/Biguelini/Link-Shortener#objetivos)
#### 💻	[Tecnologias](https://github.com/Biguelini/Link-Shortener#tecnologias)
## Sobre
A api Link-Shortener foi criada no intuito de proporcionar um backend para aplicações de encurtamento de links, de maneira fácil e rápida.
## Rotas
#### Listar todos os links

`GET /`

    Retorna:
    [
     {
      "id": "meuGit",
      "originalUrl": "https://github.com/Biguelini"
     }
    ]
#### Acesso a um link

`GET /{id}`

    Abre o site cadastrado


#### Cadastrar um link

`POST /`

    {
     "id": String,
     "originalUrl": String
    }
    
    
#### Atualizar um link

`PUT /`

    {
     "id": String,
     "originalUrl": String
    }
#### Exluir um link

`DELETE /{id}`

    Exclui o link



#### Como executar o projeto
```
  git clone https://github.com/Biguelini/Link-Shortener.git
  cd Link-Shortener/link-shortener/
  instale o maven e o jdk 17 na sua máquina
  mvn spring-boot:run
```

## Objetivos
- [X] Criar um CRUD
- [X] Utilizar VO
- [ ] Autenticalção JWT
## Tecnologias
* SpringBoot
#### Como contribuir 
```
Faça o fork do projeto e o clone local.
Faça um branch para sua contribuição.
Faça as alterações.
Faça o push.
Crie um novo Pull Request.
```
Desenvolvido por [Biguelini](https://github.com/Biguelini)
