package br.com.alura;

public class Recibo {

	private int codigo;

	public Recibo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return "Recibo: " + codigo;
	}
}
