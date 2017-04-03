package br.com.alura.java2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.alura.java2.modelos.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {

		List<ContaPoupanca> contas = new LinkedList<>();

		ContaPoupanca c1 = new ContaPoupanca(1);
		c1.deposita(100);
		ContaPoupanca c2 = new ContaPoupanca(2);
		c2.deposita(200);

		contas.add(c2);
		contas.add(c1);
		
		for(ContaPoupanca c : contas){
			System.out.println(c);
		}
		
		Collections.sort(contas);
		
		for(ContaPoupanca c : contas){
			System.out.println(c);
		}
		
		System.out.println(contas);
	}

}
