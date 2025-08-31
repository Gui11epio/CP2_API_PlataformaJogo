# 📌 CP2 - API Plataforma de Jogos
👨‍💻 Integrantes

Pedro Manzo Yokoo – RM: 556115

Fernando Fernandes Prado – RM: 557982

Guilherme Camasmie Laiber de Jesus – RM: 554894

## ⚙️ Como Usar:

1️⃣ Clone do projeto
```bash
  git clone https://github.com/Gui11epio/CP2_API_PlataformaJogo.git
```

2️⃣ Acesse a pasta
```bash
  cd CP2_API_PlataformaJogo
```

3️⃣ Build e subida dos serviços
```bash
  docker compose up -d --build
```

4️⃣ Verificar status/health
```bash
docker compose ps
docker compose logs -f db
docker compose logs -f app
```

5️⃣ Testar a API

Acesse o Swagger no navegador:
```bash
http://localhost:8080/swagger-ui/index.html#/
```

## 📂 Exemplos de Requisições
➕ Criar Plataforma (POST /plataformas)
```bash
{
  "nome": "Playstation 5",
  "empresa": "Sony",
  "precoPlataforma": 3500
}
```
```bash
{
  "nome": "Xbox Series X",
  "empresa": "Microsoft",
  "precoPlataforma": 4000
}
```
```bash
{
  "nome": "Nintendo Switch",
  "empresa": "Nintendo",
  "precoPlataforma": 2000
}
```
➕ Criar Jogo (POST /jogos)
```bash
{
  "titulo": "Uncharted 4",
  "descricao": "Um jogo de ação, aventura e exploração. uma franquia ganhadora do GOTY",
  "preco": 349.90,
  "dataLancamento": "2022-11-09",
  "plataforma": {
    "id": 1
  }
}
```
```bash
{
  "titulo": "Forza Horizon 5",
  "descricao": "O quinto jogo da série Forza Horizon, dijira pelo México e explore!",
  "preco": 200.0,
  "dataLancamento": "2021-11-09",
  "plataforma": {
    "id": 2
  }
}
```
```bash
{
  "titulo": "The Legend Of Zelda - Tears Of The Kingdom",
  "descricao": "Jogue a aclamada continuação de Breath of the Wild",
  "preco": 349.90,
  "dataLancamento": "2023-05-12",
  "plataforma": {
    "id": 3
  }
}
```

🔍 Buscar Jogos/Páginas (GET /jogos)
```bash
{
  "page": 0,
  "size": 5,
  "sort": [
    "id,asc"
  ]
}
```

✏️ Atualizar & ❌ Deletar

Use os exemplos acima alterando os valores ou IDs conforme necessário.

## 🏗️ Análise da Arquitetura
1. Serviços do Projeto

- Spring Boot App → aplicação backend

- MySQL → banco de dados usado pela aplicação

2. Dependências entre os serviços

- O Spring Boot depende do MySQL para armazenar e buscar dados.

- O MySQL é independente, mas precisa estar pronto antes do app iniciar.

- Comunicação via rede Docker interna (backend).

📌 Exemplo do fluxo:

- Cliente → (HTTP porta 8080) → Spring Boot  
- Spring Boot → (JDBC porta 3306) → MySQL

3. Estratégia de Containerização

- Spring Boot (App)

- Imagem customizada via Dockerfile

- Usuário não root

- Porta exposta: 8080

- Variáveis de ambiente para conexão com MySQL

- MySQL

- Imagem oficial mysql:8.0

- Volume para persistência (mysql_data)

- Configuração via .env (usuário, senha, database)

- Porta exposta: 3306

✅ Resumo:

- Serviços → App + MySQL

- Dependências → App depende do MySQL

Estratégia → App (imagem custom) + MySQL (imagem oficial com volume)

🖼️ Arquitetura do Projeto
Arquitetura Antiga
<img width="1536" height="1024" alt="arquitetura antiga" src="https://github.com/user-attachments/assets/cb537433-25a1-4df3-8fcb-0788c6673a32" />
Arquitetura Atual
<img width="1536" height="1024" alt="arquitetura atual" src="https://github.com/user-attachments/assets/c340dd21-6714-47d5-a06e-324d28f039b9" />
