package br.com.gbd.alura.models;

import java.math.BigDecimal;

/*
    Autor(es): José Carlos de Freitas
    Data: 23/03/2017 às 16:22:04
    Arquivo: DadosPagamento
*/

public class DadosPagamento {
    private BigDecimal value;

    public DadosPagamento(BigDecimal value) {
        this.value = value;
    }

    public DadosPagamento() {
    }

    public BigDecimal getValue() {
        return value;
    }
}