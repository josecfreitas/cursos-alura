package design.patterns.state.exercício;

public class EstadoNegativo implements Estado {

	@Override
	public Estado atualiza(Conta conta) {
		if (conta.getValor() < 0)
			return this;

		return new EstadoPositivo();
	}

	@Override
	public double depositar(double valor) {
		return valor * 0.95;
	}

	@Override
	public double sacar(double valor) {
		throw new RuntimeException("Saldo negativo não pode sacar grana");
	}
}
