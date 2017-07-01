package br.com.alura;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestaCurso {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominando as coleções Java", "Paulo Silveira");

		curso.adiciona(new Aula("Trabalhando com ArrayList", 21));
		curso.adiciona(new Aula("Arabalhando com ArrayList", 21));

		Aluno a1 = new Aluno("José Carlos", 1233);
		curso.matricula(a1);
		curso.matricula(new Aluno("Guilherme", 1234));

		System.out.println(curso.getAlunos());

		System.out.println(curso.estaMatriculado(a1));
		System.out.println(curso.estaMatriculado(new Aluno("José Carlos", 1233)));

		Recibo rec1 = new Recibo(1);
		// atribui valores
		Recibo rec2 = new Recibo(2);
		// atribui valores
		Recibo rec3 = new Recibo(3);
		// atribui valores
		
		Set<Recibo> recibos = new TreeSet<>(Comparator.comparing(Recibo::getCodigo));
		recibos.add(rec3);
		recibos.add(rec1);
		recibos.add(rec2);
		
		System.out.println(recibos);
	}
}
