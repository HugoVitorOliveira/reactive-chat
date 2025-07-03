# 📡 API de Chat Reativo com Quarkus, MongoDB e PostgreSQL

Este projeto é uma API de chat moderna e reativa, desenvolvida com **Quarkus**, utilizando **MongoDB** para persistência de mensagens e **PostgreSQL** para dados transacionais como usuários e contatos. A aplicação utiliza **WebSockets** para comunicação em tempo real e **JWT** para autenticação segura.

---

## ✅ Requisitos Funcionais

### 👤 Autenticação e Usuário
- Registro de usuários com email e senha.
- Login e autenticação via JWT.
- Atualização de perfil (nome, foto, status).

### 👥 Contatos e Salas de Chat
- Adicionar e remover contatos.
- Criação de salas privadas (1:1) ou grupos.
- Listagem de salas ativas do usuário.

### 💬 Mensagens
- Envio e recebimento de mensagens de texto em tempo real via WebSocket.
- Armazenamento de mensagens no MongoDB.
- Metadados das mensagens (data, status de leitura).

### 🕓 Histórico e Busca
- Consulta de histórico de mensagens (paginada).
- Busca de mensagens por conteúdo e data.

### 🟢 Presença e Status
- Status online/offline de usuários.
- Notificações de digitação e visualização de mensagens.

---

## ⚙️ Requisitos Não Funcionais

- Programação reativa com Quarkus (Mutiny, Vert.x).
- MongoDB reativo para mensagens.
- PostgreSQL reativo para usuários, contatos e salas.
- Autenticação JWT (stateless).
- Comunicação em tempo real via WebSocket.
- Documentação da API com OpenAPI (Swagger).
- Suporte a escalabilidade e alta disponibilidade.
- Testes unitários e de integração automatizados.
- Logging e monitoramento básico.

---

## 🧱 Tecnologias Utilizadas

- [Quarkus](https://quarkus.io/)
- [MongoDB](https://www.mongodb.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [Mutiny](https://smallrye.io/smallrye-mutiny/)
- [JWT](https://jwt.io/)
- WebSocket
- Docker (para ambientes de desenvolvimento e testes)

---

## 📌 Quebra de Tarefas (Roadmap)

### 🏁 Fase 1 — Setup Inicial e Autenticação
- [x] Criar projeto base com extensões Quarkus necessárias.
- [x] Configurar PostgreSQL e MongoDB (preferencialmente via Docker).
- [x] Implementar endpoints de registro, login e autenticação JWT.
- [x] Criar entidade de usuário (PostgreSQL reativo).
- [ ] Implementar testes unitários da autenticação.

### 📲 Fase 2 — Contatos e Salas de Chat
- [ ] Modelar entidades de Contato e Sala no PostgreSQL.
- [ ] Criar endpoints para gerenciar contatos e salas.
- [ ] Implementar validações e regras de acesso.
- [ ] Testar funcionalidades de contatos e salas.

### 💬 Fase 3 — Mensagens e Comunicação Reativa
- [ ] Modelar estrutura de mensagens no MongoDB.
- [ ] Criar serviço reativo para salvar mensagens.
- [ ] Implementar WebSocket para envio/recebimento em tempo real.
- [ ] Emitir eventos de status (digitando, entregue, lido).
- [ ] Testar o fluxo completo de troca de mensagens.

### 🔎 Fase 4 — Histórico e Presença
- [ ] Implementar consulta paginada do histórico.
- [ ] Criar busca por mensagens (texto/data).
- [ ] Gerenciar status online/offline dos usuários.
- [ ] Notificações de digitação e visualização por WebSocket.

### 📦 Fase 5 — Finalização e Deploy
- [ ] Documentar API com Swagger/OpenAPI.
- [ ] Cobertura de testes (unitários e integração).
- [ ] Preparar `Dockerfile` e `docker-compose.yml`.
- [ ] Configurar observabilidade (logs, métricas básicas).
- [ ] Publicar a aplicação (local ou cloud).

---

## 🚀 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar PRs ou sugerir melhorias.

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
