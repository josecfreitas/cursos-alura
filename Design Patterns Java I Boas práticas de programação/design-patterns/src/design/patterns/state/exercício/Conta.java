package design.patterns.state.exercício;

public class Conta {

	private String nome;
	private double valor;
	
	private Estado estado;

	public Conta(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		if(valor >= 0){
			estado = new EstadoPositivo();
		} else {
			estado = new EstadoNegativo();
		}
	}

	public double getValor() {
		return valor;
	}

	public void depositar(double valor){
		this.valor += estado.depositar(valor);
		estado = estado.atualiza(this);
	}
	
	public void sacar(double valor){
		this.valor -= estado.sacar(valor);
		estado = estado.atualiza(this);
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
