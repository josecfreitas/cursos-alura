package br.com.alura.java2.modelos;

import br.com.alura.java2.exception.ValorInvalidoException;

public abstract class Conta {

	private int numero;
	protected double saldo;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposita(double valor) {
		if(valor <= 0) {
			throw new ValorInvalidoException(valor);
		}
		this.saldo += valor;
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public abstract void atualiza(double taxa);
	
	@Override
	public String toString() {
		return "O saldo é " + this.saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		 return this.numero == ((Conta) obj).getNumero(); 
	}
}
