package design.patterns.state;

public class EstadoEmAprovacao implements Estado {

	private boolean descontoAplicado = false;

	@Override
	public double desconto(Orcamento orcamento) {
		if (descontoAplicado)
			throw new RuntimeException("Desconto já foi aplicado");

		descontoAplicado = true;
		return orcamento.getValor() * 0.05;
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		return new EstadoAprovado();
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		return new EstadoReprovado();
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento em aprovação não pode ser finalizado");
	}

}
