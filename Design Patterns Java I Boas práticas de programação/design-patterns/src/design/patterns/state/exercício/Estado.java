package design.patterns.state.exercício;

public interface Estado {

	public Estado atualiza(Conta conta);
	public double sacar(double valor);
	public double depositar(double valor);
}
