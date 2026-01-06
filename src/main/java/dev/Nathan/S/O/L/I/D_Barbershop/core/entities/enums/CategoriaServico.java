package dev.Nathan.S.O.L.I.D_Barbershop.core.entities.enums;

public enum CategoriaServico {
    CABELO("Corte e estilização de cabelo"),
    BARBA("Aparo, modelagem e terapia para barba"),
    COMBO("Combinação de Cabelo e Barba"),
    SOBRANCELHA("Design de sobrancelha"),
    TRATAMENTO("Hidratação, pigmentação ou relaxamento");

    private final String descricao;

    CategoriaServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean exigeLavatorio() {
        return this == CABELO || this == COMBO || this == TRATAMENTO;
    }
}