package design.patterns.builder;

import java.util.ArrayList;
import java.util.Arrays;

import design.patterns.observer.EnviaEmail;
import design.patterns.observer.Multiplicador;
import design.patterns.observer.NotaFiscalDao;

public class Testa {

	public static void main(String[] args) {

		NotaFiscalBuilder builder = new NotaFiscalBuilder(Arrays.asList(new EnviaEmail(), new NotaFiscalDao(),
				new Multiplicador(10), new Multiplicador(5), new Multiplicador(3)));

		builder.paraEmpresa("Razao teste").comCnpj("111.111.2.23.12312.3123").comObservacao("Testeeee")
				.com(new ItemDaNota("item1", 100)).com(new ItemDaNota("Item2", 150)).com(new ItemDaNota("Item3", 20));

		NotaFiscal notaFiscal = builder.construir();

		System.out.println(notaFiscal);
	}
}
