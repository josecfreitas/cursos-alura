package design.patterns.observer;

import design.patterns.builder.NotaFiscal;

public class Multiplicador implements AposConstrucaoNotaFiscal{

	private double multiplicador;
	
	public Multiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

	@Override
	public void executar(NotaFiscal notaFiscal) {
		System.out.println(notaFiscal.getValorBruto() * multiplicador);
	}

}
