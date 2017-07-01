package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private int tempoTotal;
	private List<Aula> aulas = new ArrayList<>();
	private Set<Aluno> alunos = new HashSet<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public void adiciona(Aula aula) {
		tempoTotal += aula.getTempo();
		this.aulas.add(aula);
	}
	
	public void matricula(Aluno aluno){
		alunos.add(aluno);
	}

	public int getTempoTotal() {
//		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
		return tempoTotal;
	}

	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + getTempoTotal() + ", aulas: " + aulas
+ " ]";
	}

	public boolean estaMatriculado(Aluno aluno) {
		return alunos.contains(aluno);
	}
}
