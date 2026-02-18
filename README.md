# ⚽ AgendaFut - Sistema de Agendamento de Quadra

Sistema backend para gerenciamento de agendamentos de quadra esportiva.

Projeto desenvolvido com foco em boas práticas de backend utilizando
Spring Boot, JPA e PostgreSQL.

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java 17+
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   PostgreSQL
-   Lombok
-   Maven

------------------------------------------------------------------------

## 📌 Objetivo do Projeto

Criar uma API REST para:

-   Cadastro de clientes
-   Cadastro de múltiplos telefones por cliente
-   Controle de agendamentos (aluguéis)
-   Validações de regras de negócio
-   Prevenção de conflitos de horário

------------------------------------------------------------------------

# 🧠 Regras de Negócio Implementadas

## 👤 Cliente

-   Nome obrigatório
-   CPF único
-   E-mail opcional (único quando informado)
-   Um cliente pode possuir múltiplos telefones
-   Telefones armazenados em tabela separada (relacionamento 1:N)

------------------------------------------------------------------------

## ⚽ Aluguel

-   Data obrigatória
-   Hora início obrigatória
-   Hora fim obrigatória
-   Valor fixo por horário
-   Um cliente pode ter vários aluguéis

------------------------------------------------------------------------

## 🔒 Validações Implementadas

-   [x] CPF não pode ser duplicado
-   [x] E-mail não pode ser duplicado
-   [x] Hora fim deve ser maior que hora início
-   [x] Validação de conflito de horário
-   [x] Exception personalizada para conflitos
-   [x] Separação de telefones em tabela própria
-   [x] Uso de DTO para Cliente

------------------------------------------------------------------------

# 🧪 Exemplo de Requisição

### Criar Aluguel

``` json
{
  "data": "2026-02-17",
  "horaInicio": "16:00",
  "horaFim": "17:00",
  "cliente": {
    "id": 3
  }
}
```

------------------------------------------------------------------------

# 🗂️ Estrutura do Projeto

    controller/
    service/
    repository/
    entity/
    dto/
    exceptions/

------------------------------------------------------------------------

# 🛣️ Roadmap (Próximas Etapas)

-   [ ] Bloquear agendamento em datas passadas
-   [ ] Implementar GlobalExceptionHandler
-   [ ] Melhorar retorno de erros (HTTP 400 / 409)
-   [ ] Separar DTO de Request e Response
-   [ ] Implementar paginação na listagem
-   [ ] Criar endpoint de listagem por data
-   [ ] Criar endpoint para buscar agenda diária
-   [ ] Adicionar documentação com Swagger

------------------------------------------------------------------------

# 🎯 Melhorias Futuras

-   Autenticação com Spring Security
-   Controle de usuários (admin / operador)
-   Deploy em nuvem (Render, Railway ou AWS)
-   Dockerização da aplicação
-   Testes unitários com JUnit e Mockito

------------------------------------------------------------------------

# 📚 Aprendizados Aplicados

-   Modelagem de relacionamento 1:N
-   Escrita de queries customizadas com JPQL
-   Validação de regras de negócio no Service
-   Debug de consultas Hibernate
-   Boas práticas de organização em camadas

------------------------------------------------------------------------

# 🧑‍💻 Autor
- Desenvolvedor: Israel Abreu de Oliveira