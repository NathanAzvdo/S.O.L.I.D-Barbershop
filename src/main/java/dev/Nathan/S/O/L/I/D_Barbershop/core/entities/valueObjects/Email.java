package dev.Nathan.S.O.L.I.D_Barbershop.core.entities.valueObjects;

public record Email(String endereco) {
    public Email {
        if (endereco == null || !endereco.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("E-mail inválido: " + endereco);
        }
    }
}