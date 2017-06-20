package design.patterns.observer;

import design.patterns.builder.NotaFiscal;

public class NotaFiscalDao implements AposConstrucaoNotaFiscal {

	@Override
	public void executar(NotaFiscal notaFiscal) {
		System.out.println("salvando na base");
	}

}
