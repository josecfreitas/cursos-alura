package br.com.caelum.ano;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class AnoTest {

	@Test
	public void anoEhBissexto(){
		Ano ano = new Ano(2016);
		
		assertEquals(true, ano.ehBissexto());
	}

	@Test
	public void anoNaoEhBissexto(){
		Ano ano = new Ano(2014);
		
		assertEquals(false, ano.ehBissexto());
	}

	@Test
	public void anoEhBissextoCentenario(){
		Ano ano = new Ano(1600);
		
		assertEquals(true, ano.ehBissexto());
	}

	@Test
	public void anoNaoEhBissextoCentenario(){
		Ano ano = new Ano(200);
		
		assertEquals(false, ano.ehBissexto());
	}

	@Test
	public void ano0EhBissexto(){
		Ano ano = new Ano(0);
		
		assertEquals(true, ano.ehBissexto());
	}
}
