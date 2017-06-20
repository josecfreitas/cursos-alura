package design.patterns.template.method;

public class CalculadorDeImpostos {

	public void calculaImposto(Orcamento orcamento, Imposto imposto){
		double valor = orcamento.getValor() + imposto.calcula(orcamento);
		
		System.out.println(valor);
	}
}
