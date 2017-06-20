package design.patterns.chain.of.responsability.exercício;

public class Conta {

	private String nome;
	private double valor;

	public Conta(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void depositar(double valor){
		this.valor += valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome + " : " + valor;
	}
}
