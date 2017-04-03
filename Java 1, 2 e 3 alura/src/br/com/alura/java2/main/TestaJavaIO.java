package br.com.alura.java2.main;

import java.io.*;

public class TestaJavaIO {

	public static void main(String[] args) throws FileNotFoundException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("arquivo.txt")));) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
