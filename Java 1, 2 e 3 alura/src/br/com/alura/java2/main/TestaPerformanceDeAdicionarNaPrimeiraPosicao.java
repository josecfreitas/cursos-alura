package br.com.alura.java2.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestaPerformanceDeAdicionarNaPrimeiraPosicao {

	public static void main(String[] args) {
        System.out.println("Iniciando...");
        long inicio = System.currentTimeMillis();

        // trocar depois por ArrayList                
        List<Integer> teste = new LinkedList<Integer>();

        for (int i = 0; i < 30000; i++) {
            teste.add(0, i);
        }
        
        teste.get(teste.size()-1);

        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        System.out.println("Tempo gasto: " + tempo);
    }
}
