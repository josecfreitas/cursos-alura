package design.patterns.decorator;

public class Testa {

	public static void main(String[] args) {
		Iccc iccc = new Iccc(new Iss(new Icms()));
		Imposto imposto = new ImpostoMuitoAlto(iccc);
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new Item("Lapi", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		
		CalculadorDeImpostos calculadora = new CalculadorDeImpostos();

		calculadora.calculaImposto(orcamento, imposto);
	}
}
