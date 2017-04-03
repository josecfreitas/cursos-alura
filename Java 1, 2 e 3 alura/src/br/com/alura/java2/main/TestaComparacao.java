package br.com.alura.java2.main;

import br.com.alura.java2.modelos.ContaCorrente;

public class TestaComparacao {

	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente();
		ContaCorrente c2 = new ContaCorrente();
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
	}
}
