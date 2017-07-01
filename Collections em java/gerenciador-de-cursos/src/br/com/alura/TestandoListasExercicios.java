package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestandoListasExercicios {

	public static void main(String[] args) {
		List<String> cursos = new ArrayList<>();
		
		cursos.add("Java 8: Tire proveito dos novos recursos da linguagem");
		cursos.add("Apache Camel");
		cursos.add("Certificacao Java SE 8 Programmer I");
		
		cursos.remove(1);
		
		System.out.println(cursos);
		
		System.out.println("O primeiro curso da lista é: " + cursos.get(0));
		
		Collections.sort(cursos);
		
		System.out.println(cursos);
	}
}
