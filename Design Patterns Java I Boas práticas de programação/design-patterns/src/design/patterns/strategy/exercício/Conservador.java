package design.patterns.strategy.exercício;

public class Conservador implements Investidor {
	
	@Override
	public double retorno(Conta conta) {
		return conta.getValor() * 0.008;
	}
	
}
