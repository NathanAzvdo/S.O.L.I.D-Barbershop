# 💈 S.O.L.I.D Barbershop

**"Onde cada linha de código é um corte de mestre."**

Este projeto é uma API para gestão de barbearias, desenvolvida como um "projeto espelho" para o aprendizado de **Clean Architecture**. O objetivo é aplicar os padrões aprendidos em aula (baseados em um sistema de eventos) no domínio de agendamentos de cortes e serviços de estética masculina.

## 🎯 Objetivo de Aprendizado
Diferente de apenas replicar o conteúdo das aulas, este projeto foca na transição de padrões tradicionais para arquiteturas escaláveis:
- **Independência de Frameworks:** O domínio é isolado e não conhece o Spring Boot.
- **Testabilidade:** Regras de negócio validadas sem necessidade de subir banco de dados.
- **Evolução de Código:** Migração do padrão *Transaction Script* (visto no projeto AcadPlanner) para um *Domain Model* rico e inteligente.

## 🏗️ Estrutura da Arquitetura
O projeto segue a divisão em quatro camadas concêntricas:

1. **Domain (Coração):** Contém as **Entities** (classes puras com lógica de negócio), **Exceptions** e os **Gateways** (interfaces de repositório).
2. **Application (Casos de Uso):** Onde residem os **Use Cases** que executam ações específicas, como `RealizarAgendamento`.
3. **Interface Adapters:** Responsável por converter dados entre a aplicação e o mundo externo (Controllers e Mappers).
4. **Infrastructure:** Implementações técnicas como **Persistence** (Spring Data JPA) e configurações de segurança.

## 🧭 Regras de Ouro do Projeto
- **Entidades Ricas:** Diferente das entidades anêmicas do AcadPlanner, aqui a lógica de disponibilidade e tempo deve morar nos objetos de domínio.
- **Inversão de Dependência:** O Caso de Uso depende de uma interface no domínio, não da implementação do banco.
- **Cálculo de Duração:** O fim do atendimento é calculado automaticamente com base no tipo de serviço selecionado (Corte, Barba ou Combo).

## 🛠️ Stack Tecnológica
Baseada nas tecnologias modernas utilizadas no ecossistema de desenvolvimento anterior:
- **Java 21**
- **Spring Boot 3.4.2**
- **PostgreSQL**
- **Flyway** (Gestão de migrations de banco de dados)
- **Spring Security & JWT** (Autenticação e autorização)

## 🚀 De / Para (Guia de Implementação)
Para facilitar o acompanhamento das aulas, utilize este mapeamento:

| Aula do Curso (Eventos) | Sua Implementação (Barbearia) |
| :--- | :--- |
| **Venue** (Local) | **Barbeiro** (O recurso com agenda) |
| **Event** (Evento) | **Agendamento** (A ação de cortar/tratar) |
| **Booking** (Reserva) | **Reserva de Horário** |
| **Event Category** | **Serviço** (Cabelo, Barba, Pigmentação) |

---
*Este projeto foi inspirado nos princípios de Robert C. Martin (Uncle Bob) e no desejo de criar sistemas mais robustos e fáceis de manter.*