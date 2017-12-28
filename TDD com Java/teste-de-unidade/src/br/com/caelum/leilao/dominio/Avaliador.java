package br.com.caelum.leilao.dominio;

public class Avaliador {

	private double maiorValor = Double.NEGATIVE_INFINITY;
	private double menorValor = Double.POSITIVE_INFINITY;
	private double valorMedio;
	
	public void avalia(Leilao leilao){
		for (Lance lance : leilao.getLances()) {
			valorMedio += lance.getValor();
			
			if(lance.getValor() >= maiorValor) maiorValor = lance.getValor();
			if(lance.getValor() <= menorValor) menorValor= lance.getValor();
		}
		
		valorMedio /= leilao.getLances().size();
	}

	public double getMaiorLance() {
		return maiorValor;
	}

	public double getMenorLance() {
		return menorValor;
	}

	public double valorMedio() {
		return valorMedio;
	}
}
