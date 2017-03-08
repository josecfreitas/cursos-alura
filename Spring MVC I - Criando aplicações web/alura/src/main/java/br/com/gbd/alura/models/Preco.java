package br.com.gbd.alura.models;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

/*
    Autor(es): José Carlos de Freitas
    Data: 06/03/2017 às 23:14:50
    Arquivo: Preco
*/

@Embeddable
public class Preco {

    private BigDecimal valor;
    private TipoPreco tipo;
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }
}