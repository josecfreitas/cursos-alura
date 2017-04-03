package br.com.alura.java2.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestaScanner {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream is = System.in;
		Scanner entrada = new Scanner(is);
		
		PrintStream saida = new PrintStream(new FileOutputStream("saida.txt"));
		
		System.out.println("Digite sua mensagem: ");
		while(entrada.hasNextLine()){
			String line = entrada.nextLine();
			System.out.println(line);
			
			saida.print(line + "\n");
		}
		entrada.close();
		saida.close();
	}
}
