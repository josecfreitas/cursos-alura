package design.patterns.decorator;

public interface Desconto {

	public double calcula(Orcamento orcamento);
	public void setProximo(Desconto proximo);
}
