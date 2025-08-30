Pedro Manzo Yokoo/ 556115 

Fernando Fernandes Prado /557982 

Guilherme Camasmie Laiber de Jesus/554894  


== COMO USAR ==
=
1- No cmd faça um clone do projeto usando:
=
"git clone https://github.com/Gui11epio/CP2_API_PlataformaJogo.git"

2- Entre no projeto usando o comado:
=
"cd CP2_API_PlataformaJogo"

3- Faça o build da imagem da app e subida dos serviços:
=
"docker compose up -d --build"

4- Verificar status/health:
=
docker compose ps
docker compose logs -f db
docker compose logs -f app

5- Testar a API
=
link do swagge:
http://localhost:8080/swagger-ui/index.html#/

Para o POST:
=
Plataforma:

{
  "nome": "Playstation 5",
  "empresa": "Sony",
  "precoPlataforma": 3500
}

{
  "nome": "Xbox Series X",
  "empresa": "Microsoft",
  "precoPlataforma": 4000
}

{
  "nome": "Nintendo Switch",
  "empresa": "Nintendo",
  "precoPlataforma": 2000
}

Jogo:

{
  "titulo": "Uncharted 4",
  "descricao": "Um jogo de ação, aventura e exploração. uma franquia ganhadora do GOTY",
  "preco": 349.90,
  "dataLancamento": "2022-11-09",
  "plataforma": {
    "id": 1
  }
}

{
  "titulo": "Forza Horizon 5",
  "descricao": "O quinto jogo da série Forza Horizon, dijira pelo México e explore!",
  "preco": 200.0,
  "dataLancamento": "2021-11-09",
  "plataforma": {
    "id": 2
  }
}

{
  "titulo": "The Legend Of Zelda - Tears Of The Kingdom",
  "descricao": "Jogue a aclamada continuação de Breath of the Wild",
  "preco": 349.90,
  "dataLancamento": "2023-05-12",
  "plataforma": {
    "id": 3
  }
}


Para o GET:
=
{
  "page": 0,
  "size": 5,
  "sort": [
    "id,asc"
  ]
}

Para o atualizar e deletar:
=
-É só usar outro exemplo que foi colocado

 =/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/
== ANALISE DA ARQUITETURA ==
=
1. Os serviços do projeto
Os serviços principais são:

Spring Boot App → aplicação backend.

MySQL → banco de dados usado pela aplicação.
2. Mapeie as dependências entre os serviços (0,4 pontos)

Como eles se conectam:

O Spring Boot depende do MySQL para armazenar e buscar dados.

O MySQL é independente, mas precisa estar pronto antes do app iniciar.

Ambos os serviços se comunicam pela rede Docker interna (backend).

 Exemplo de mapeamento:

Cliente → envia requisições HTTP (porta 8080) → Spring Boot

Spring Boot → JDBC (porta 3306) → MySQL

3. Estratégia de containerização para cada componente

como vai rodar cada parte no Docker:

Spring Boot (App)

Cria uma imagem customizada via Dockerfile

Usa usuário não root.

Expoe porta 8080.

Configura variáveis de ambiente para conectar ao MySQL.

MySQL

Usa imagem oficial do Docker Hub (mysql:8.0).

Monta volume para persistência dos dados (mysql_data).

Configura variáveis de ambiente no .env (usuário, senha, database).

Expor porta 3306.

Resumindo:

Serviços → App + MySQL

Dependências → App depende do MySQL

Estratégia → App com imagem custom, MySQL com imagem oficial e volume

=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/
== ARQUITETURA DO PROJETO ==
=

== AQUITETURA ANTIGA ==
=
<img width="1536" height="1024" alt="arquitetura antiga" src="https://github.com/user-attachments/assets/cb537433-25a1-4df3-8fcb-0788c6673a32" />

== ARQUITETURA ATUAL ==
=
<img width="1536" height="1024" alt="arquitetura atual" src="https://github.com/user-attachments/assets/c340dd21-6714-47d5-a06e-324d28f039b9" />
