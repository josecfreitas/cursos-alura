package design.patterns.state;

public class EstadoFinalizado implements Estado {

	@Override
	public double desconto(Orcamento orcamento) {
		throw new RuntimeException("Orçamento finalizado não tem desconto");
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento finalizado não pode ser alterado");
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento finalizado não pode ser alterado");
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento finalizado não pode ser alterado");
	}

}
