package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {
	public static void main(String[] args) {

		Set<String> alunos = new HashSet<>();
		alunos.add("Paulo");
		alunos.add("Alberto");
		alunos.add("Pedro");
		alunos.add("Nico");
		
		System.out.println(alunos.size());
		alunos.forEach(System.out::println);
		
		alunos.add(new String("Paulo"));
		
		System.out.println(alunos.size());
	}
}
