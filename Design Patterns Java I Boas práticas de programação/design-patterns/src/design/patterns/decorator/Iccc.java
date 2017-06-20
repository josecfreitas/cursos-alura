package design.patterns.decorator;

public class Iccc extends Imposto {

	public Iccc() {
		super();
	}

	public Iccc(Imposto proxImposto) {
		super(proxImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		if (orcamento.getValor() < 1000)
			return orcamento.getValor() * 0.05 + calculaProxImposto(orcamento);
		else if (orcamento.getValor() >= 1000 && orcamento.getValor() <= 3000)
			return orcamento.getValor() * 0.07 + calculaProxImposto(orcamento);
		else
			return orcamento.getValor() * 0.08 + calculaProxImposto(orcamento);
	}
}
