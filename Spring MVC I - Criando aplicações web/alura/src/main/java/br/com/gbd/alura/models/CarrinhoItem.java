package br.com.gbd.alura.models;

import java.math.BigDecimal;

/*
    Autor(es): José Carlos de Freitas
    Data: 13/03/2017 às 10:27:47
    Arquivo: ProdutoItems
 */
public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipoPreco;
    
    public BigDecimal getPreco(){
        return produto.precoPara(tipoPreco);
    }

    public CarrinhoItem(Produto produto, TipoPreco tipo) {
        this.produto = produto;
        this.tipoPreco = tipo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.produto != null ? this.produto.hashCode() : 0);
        hash = 37 * hash + (this.tipoPreco != null ? this.tipoPreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarrinhoItem other = (CarrinhoItem) obj;
        if (this.produto != other.produto && (this.produto == null || !this.produto.equals(other.produto))) {
            return false;
        }
        if (this.tipoPreco != other.tipoPreco) {
            return false;
        }
        return true;
    }

    public BigDecimal getTotal(int quantidade) {
        return getPreco().multiply(new BigDecimal(quantidade));
    }
}
