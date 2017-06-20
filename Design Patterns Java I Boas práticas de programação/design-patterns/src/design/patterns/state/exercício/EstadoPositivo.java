package design.patterns.state.exercício;

public class EstadoPositivo implements Estado {

	@Override
	public Estado atualiza(Conta conta) {
		if (conta.getValor() < 0)
			return new EstadoNegativo();

		return this;
	}


	@Override
	public double sacar(double valor) {
		return valor;
	}

	@Override
	public double depositar(double valor) {
		return valor * 0.98;
	}

}
