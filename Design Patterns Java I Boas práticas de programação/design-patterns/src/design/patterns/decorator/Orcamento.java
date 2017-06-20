package design.patterns.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

	private double valor;
	private List<Item> itens = new ArrayList<>();

	public Orcamento() {
	}

	public double getValor() {
		return valor;
	}
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public void adicionarItem(Item item){
		this.valor += item.getValor();
		itens.add(item);
	}
}
