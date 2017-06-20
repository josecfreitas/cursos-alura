package design.patterns.state;

public class EstadoReprovado implements Estado {

	@Override
	public double desconto(Orcamento orcamento) {
		throw new RuntimeException("Orçamento reprovado não tem desconto");
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento reprovado não pode ser aprovado");
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento reprovado não pode ser reprovado");
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		return new EstadoFinalizado();
	}

}
