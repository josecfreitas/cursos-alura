package design.patterns.state;

public class EstadoAprovado implements Estado {

	private boolean descontoAplicado = false;

	@Override
	public double desconto(Orcamento orcamento) {
		if (descontoAplicado )
			throw new RuntimeException("Desconto já foi aplicado");

		descontoAplicado = true;
		return orcamento.getValor() * 0.02;
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento aprovado não pode ser aprovado");
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento aprovado não pode ser reprovado");
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		return new EstadoFinalizado();
	}

}
