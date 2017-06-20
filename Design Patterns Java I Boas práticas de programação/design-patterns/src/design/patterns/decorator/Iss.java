package design.patterns.decorator;

public class Iss extends Imposto {

	public Iss() {
		super();
	}

	public Iss(Imposto proxImposto) {
		super(proxImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculaProxImposto(orcamento);
	}
}
