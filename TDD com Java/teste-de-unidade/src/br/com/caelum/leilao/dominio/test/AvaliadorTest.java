package br.com.caelum.leilao.dominio.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	@Test
	public void testaLancesDeFormaCrescente() {
//		#1 - Cenário
		Usuario jose = new Usuario(1, "José");
		Usuario giovana = new Usuario(2, "Giovana");
		
		Leilao leilao = new Leilao("Leilão de testes");

		leilao.propoe(new Lance(jose, 250.0));
		leilao.propoe(new Lance(giovana, 400.0));
		leilao.propoe(new Lance(jose, 550.0));
		
//		#2 - Ação
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

//		#3 - Validação
		Assert.assertEquals(250.0, avaliador.getMenorLance(), 0.0001);
		Assert.assertEquals(550.0, avaliador.getMaiorLance(), 0.0001);
		Assert.assertEquals(400.0, avaliador.valorMedio(), 0.0001);
	}
	
}
