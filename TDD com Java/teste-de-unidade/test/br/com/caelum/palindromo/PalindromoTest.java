package br.com.caelum.palindromo;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.palindromo.Palindromo;

public class PalindromoTest {

	@Test
	public void ehPalindromoIgualATrue(){
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos");
		
		Assert.assertTrue(ehPalindromo);
	}

	@Test
	public void ehPalindromoIgualAFalse(){
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo("Essa não é palindroma");
		
		Assert.assertFalse(ehPalindromo);
	}
}
