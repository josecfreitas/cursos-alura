package design.patterns.decorator;

public abstract class Imposto {

	protected Imposto proxImposto;

	public Imposto() {
	}

	public Imposto(Imposto proxImposto) {
		this.proxImposto = proxImposto;
	}

	public abstract double calcula(Orcamento orcamento);
	
	protected double calculaProxImposto(Orcamento orcamento){
		if(proxImposto == null) return 0;
		return proxImposto.calcula(orcamento);
	}
}
