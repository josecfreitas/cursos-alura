package design.patterns.decorator;

public class Icms extends Imposto {

	public Icms() {
	}

	public Icms(Imposto proxImposto) {
		super(proxImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50 + calculaProxImposto(orcamento);
	}
}
