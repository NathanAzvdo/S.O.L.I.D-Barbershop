package dev.Nathan.S.O.L.I.D_Barbershop.core.entities;
import dev.Nathan.S.O.L.I.D_Barbershop.core.entities.enums.CategoriaServico;

import java.math.BigDecimal;
import java.time.Duration;

public record Servico(
        String nome,
        String descricao,
        BigDecimal preco,
        Duration duracao,
        CategoriaServico categoria
) {
    public Servico {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        if (duracao == null || duracao.isNegative() || duracao.isZero()) {
            throw new IllegalArgumentException("Duração deve ser positiva");
        }
    }
}