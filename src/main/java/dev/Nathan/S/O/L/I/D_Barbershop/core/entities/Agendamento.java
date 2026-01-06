package dev.Nathan.S.O.L.I.D_Barbershop.core.entities;

import dev.Nathan.S.O.L.I.D_Barbershop.core.entities.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public class Agendamento {
    private final UUID id;
    private final UUID clienteId;
    private final Barbeiro barbeiro;
    private final Servico servico;
    private final LocalDateTime dataHoraInicio;
    private StatusAgendamento status;

    public Agendamento(UUID clienteId, Barbeiro barbeiro, Servico servico, LocalDateTime dataHoraInicio) {
        this.id = UUID.randomUUID();
        this.clienteId = clienteId;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.dataHoraInicio = dataHoraInicio;
        this.status = StatusAgendamento.PENDENTE;
        validar();
    }

    public LocalDateTime calcularDataHoraFim() {
        return this.dataHoraInicio.plus(this.servico.duracao());
    }

    public void confirmar() {
        if (this.status == StatusAgendamento.CANCELADO) {
            throw new IllegalStateException("Não é possível confirmar um agendamento cancelado.");
        }
        this.status = StatusAgendamento.CONFIRMADO;
    }

    public void cancelar() {
        if (!this.status.podeSerCancelado()) {
            throw new IllegalStateException("Agendamento já concluído não pode ser cancelado.");
        }
        // Regra de Negócio: Não pode cancelar faltando menos de 2h (exemplo)
        if (LocalDateTime.now().plusHours(2).isAfter(this.dataHoraInicio)) {
            throw new IllegalStateException("Cancelamento só permitido com 2h de antecedência.");
        }
        this.status = StatusAgendamento.CANCELADO;
    }

    private void validar() {
        if (dataHoraInicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar no passado.");
        }
        if (!barbeiro.isAtivo()) {
            throw new IllegalArgumentException("O barbeiro selecionado está inativo.");
        }
    }
    public UUID getId() { return id; }
    public StatusAgendamento getStatus() { return status; }
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }
}