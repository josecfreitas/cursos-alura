package design.patterns.chain.of.responsability;

public interface Desconto {

	public double calcula(Orcamento orcamento);
	public void setProximo(Desconto proximo);
}
