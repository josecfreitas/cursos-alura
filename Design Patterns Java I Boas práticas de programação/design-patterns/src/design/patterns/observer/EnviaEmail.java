package design.patterns.observer;

import design.patterns.builder.NotaFiscal;

public class EnviaEmail implements AposConstrucaoNotaFiscal {

	@Override
	public void executar(NotaFiscal notaFiscal) {
		System.out.println("Enviando email");
	}

}
