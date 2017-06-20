package design.patterns.state;

import design.patterns.decorator.Item;

public class Testa {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new Item("Item1", 100));
		orcamento.adicionarItem(new Item("Item1", 100));
		orcamento.adicionarItem(new Item("Item1", 100));
		orcamento.adicionarItem(new Item("Item1", 100));
		
		orcamento.aprovar();
		orcamento.desconto();
		orcamento.finalizar();
		
		System.out.println(orcamento.getValor());
	}
}
