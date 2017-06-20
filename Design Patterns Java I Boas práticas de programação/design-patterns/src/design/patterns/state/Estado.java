package design.patterns.state;

public interface Estado {

	public double desconto(Orcamento orcamento);
	
	public Estado aprovar(Orcamento orcamento);
	public Estado reprovar(Orcamento orcamento);
	public Estado finalizar(Orcamento orcamento);
}
