package dev.Nathan.S.O.L.I.D_Barbershop.core.entities;
import dev.Nathan.S.O.L.I.D_Barbershop.core.entities.valueObjects.Email;

import java.util.UUID;

public class Barbeiro {
    private final UUID id;
    private String nome;
    private Email email;
    private boolean ativo;

    public Barbeiro(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = new Email(email);
        this.ativo = true;
        validar();
    }

    public Barbeiro(UUID id, String nome, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = new Email(email);
        this.ativo = ativo;
        validar();
    }

    public void desativar() {
        this.ativo = false;
    }

    private void validar() {
        if (this.nome == null || this.nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório");
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email.endereco(); }
    public boolean isAtivo() { return ativo; }
}