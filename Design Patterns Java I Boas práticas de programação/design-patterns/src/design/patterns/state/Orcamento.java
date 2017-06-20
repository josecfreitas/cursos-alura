package design.patterns.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import design.patterns.decorator.Item;

public class Orcamento {

	private double valor;
	private List<Item> itens = new ArrayList<>();
	private Estado estado;

	public Orcamento() {
		estado = new EstadoEmAprovacao();
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
	
	public void desconto(){
		valor = valor - estado.desconto(this);
	}
	
	public void aprovar(){
		estado = estado.aprovar(this);
	}
	
	public void reprovar(){
		estado = estado.reprovar(this);
	}
	
	public void finalizar(){
		estado = estado.finalizar(this);
	}
}
