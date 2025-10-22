## Descrição
- Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar tarefas, ela permite listar, atualizar, criar e excluir tarefas.

## Feramentas Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL
- Maven

 ## 📁 Estrutura do Projeto

```text
src/
├── main/
│   ├── java/com/app/
│   │   ├── model/        # Entidade Task
│   │   ├── repository/   # Interface TaskRepository
│   │   ├── service/      # Lógica de negócio
│   │   └── controller/   # Endpoints REST
│   └── resources/
│       └── application.properties
