package design.patterns.strategy.exercício;

public class Conta {

	private double valor;

	public Conta(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void depositar(double valor){
		this.valor += valor;
	}
}
