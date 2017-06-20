package design.patterns.chain.of.responsability.exercício;

public class Arrojado implements Investidor {

	@Override
	public double retorno(Conta conta) {
		double chance = new java.util.Random().nextDouble();
		if (chance <= 0.2)
			return conta.getValor() * 0.05;
		else if (chance <= 0.5)
			return conta.getValor() * 0.03;
		else
			return conta.getValor() * 0.006;
	}

}
