package dev.Nathan.S.O.L.I.D_Barbershop.core.entities.enums;

public enum StatusAgendamento {
    PENDENTE,
    CONFIRMADO,
    CONCLUIDO,
    CANCELADO;

    public boolean podeSerCancelado() {
        return this == PENDENTE || this == CONFIRMADO;
    }
}