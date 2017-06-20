package design.patterns.chain.of.responsability;

public class CalculadorDeDesconto {

	public void calcula(Orcamento orcamento){
		Desconto d1 = new DescontoPorMaisDeCincoItens();
		Desconto d2 = new DescontoPorValorMaiorQuinhentos();
		Desconto d3 = new DescontoPorLapisOuCaneta();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		double valor = orcamento.getValor() - d1.calcula(orcamento);

		System.out.println(valor);
	}
}
