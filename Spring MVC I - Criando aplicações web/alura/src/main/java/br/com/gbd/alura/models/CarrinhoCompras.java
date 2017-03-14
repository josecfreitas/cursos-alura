package br.com.gbd.alura.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/*
    Autor(es): José Carlos de Freitas
    Data: 13/03/2017 às 10:38:02
    Arquivo: CarrinhoCompras
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
    
    public Collection<CarrinhoItem> getItens(){
        return this.itens.keySet();
    }

    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }

    public int getQuantidade(CarrinhoItem item) {
        if (itens.containsKey(item)) {
            return itens.get(item);
        }
        return 0;
    }

    public int getQuantidade() {
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }
    
    public BigDecimal getTotal(CarrinhoItem item){
        return item.getTotal(getQuantidade(item));
    }
    
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for(CarrinhoItem item : getItens()){
            total.add(getTotal(item));
        }
        return total;
    }
}
