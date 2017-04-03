package br.com.alura.java2.modelos;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {
	
	private String nome;
	
	public ContaPoupanca(){
		
	}

	public ContaPoupanca(int i) {
		this.setNumero(i);
	}

	public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 3;
    }

    public void deposita(double valor) {
        this.saldo += valor - 0.10;
    }

	@Override
	public int compareTo(ContaPoupanca outra) {
		return this.nome.compareTo(outra.nome);
	}
}
