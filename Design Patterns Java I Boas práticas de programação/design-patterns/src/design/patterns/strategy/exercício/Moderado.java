package design.patterns.strategy.exercício;

public class Moderado implements Investidor {

	@Override
	public double retorno(Conta conta) {
		double chance = new java.util.Random().nextDouble();
		if(chance <= 0.5)
			return conta.getValor() * 0.025;
		else
			return conta.getValor() * 0.007;
	}

}
