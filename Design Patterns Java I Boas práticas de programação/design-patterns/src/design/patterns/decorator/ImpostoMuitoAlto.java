package design.patterns.decorator;

public class ImpostoMuitoAlto extends Imposto {

	public ImpostoMuitoAlto() {
		super();
	}

	public ImpostoMuitoAlto(Imposto proxImposto) {
		super(proxImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.2 + calculaProxImposto(orcamento);
	}

}
