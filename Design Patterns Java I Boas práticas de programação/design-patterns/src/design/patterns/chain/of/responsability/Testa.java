package design.patterns.chain.of.responsability;

public class Testa {

	public static void main(String[] args) {
		Icms icms = new Icms();
		Iss iss = new Iss();
		Iccc iccc = new Iccc();
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new Item("Lapi", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		orcamento.adicionarItem(new Item("Teste", 100));
		
		CalculadorDeDesconto calculadora = new CalculadorDeDesconto();

		calculadora.calcula(orcamento);
	}
}
