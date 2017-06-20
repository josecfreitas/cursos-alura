package design.patterns.strategy;

public class Testa {

	public static void main(String[] args) {
		Icms icms = new Icms();
		Iss iss = new Iss();
		Iccc iccc = new Iccc();
		
		Orcamento orcamento = new Orcamento(100);
		
		CalculadorDeImpostos calculadora = new CalculadorDeImpostos();

		calculadora.calculaImposto(orcamento, icms);
		calculadora.calculaImposto(orcamento, iss);
		calculadora.calculaImposto(orcamento, iccc);
	}
}
