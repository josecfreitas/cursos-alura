package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class LeilaoTest {

	@Test
	public void testeBasicoLeilao() {
		Leilao leilao = new Leilao("Leilão de Computadores");

		assertEquals(leilao.getLances().size(), 0);
	}

	@Test
	public void leilaoNaoDeveAceitar2LancesSeguidosDoMesmosUsuario() {
		Leilao leilao = new Leilao("Leilao de Mac Books");

		Usuario usuario = new Usuario("José Carlos");
		leilao.propoe(new Lance(usuario, 1000.0));
		leilao.propoe(new Lance(usuario, 2000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void limiteDe5LancesPorUsuario() {
		Leilao leilao = new Leilao("Ferrari");
		
		Usuario joseCarlos = new Usuario("José Carlos");
		Usuario giovana = new Usuario("Giovana");
		
		leilao.propoe(new Lance(joseCarlos, 1000.0));
		leilao.propoe(new Lance(giovana, 2000.0));
		
		leilao.propoe(new Lance(joseCarlos, 4000.0));
		leilao.propoe(new Lance(giovana, 5000.0));
		
		leilao.propoe(new Lance(joseCarlos, 6000.0));
		leilao.propoe(new Lance(giovana, 7000.0));
		
		leilao.propoe(new Lance(joseCarlos, 9000.0));
		leilao.propoe(new Lance(giovana, 9500.0));
		
		leilao.propoe(new Lance(joseCarlos, 10000.0));
		leilao.propoe(new Lance(giovana, 11000.0));
		
		leilao.propoe(new Lance(joseCarlos, 12000.0));
		leilao.propoe(new Lance(giovana, 13000.0));
		leilao.propoe(new Lance(joseCarlos, 12000.0));
		leilao.propoe(new Lance(giovana, 13000.0));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(9).getValor(), 0.00001);
	}
	
	@Test
	public void dobrarLanceDoUsuario(){
		Leilao leilao = new Leilao("Leilao de motos");
		
		Usuario joseCarlos = new Usuario("José Carlos");
		Usuario jovana = new Usuario("Jovana");
		
		leilao.propoe(new Lance(joseCarlos, 1000.0));
		leilao.propoe(new Lance(jovana, 2000.0));
		
		leilao.dobrarLance(joseCarlos);
		leilao.dobrarLance(jovana);
		
		assertEquals(4, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(2).getValor(), 0.00001);
		assertEquals(4000.0, leilao.getLances().get(3).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveDobrarSeNaoTiverLances(){
		Leilao leilao = new Leilao("Leilao de motos");
		
		Usuario joseCarlos = new Usuario("José Carlos");
		Usuario jovana = new Usuario("Jovana");
		
		leilao.dobrarLance(joseCarlos);
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(joseCarlos, 2000.0));
		leilao.dobrarLance(jovana);

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveDobraSeAtingirLimiteDe5Lances(){

		Leilao leilao = new Leilao("Ferrari");
		
		Usuario joseCarlos = new Usuario("José Carlos");
		Usuario giovana = new Usuario("Giovana");
		
		leilao.propoe(new Lance(joseCarlos, 1000.0));
		leilao.propoe(new Lance(giovana, 2000.0));
		
		leilao.propoe(new Lance(joseCarlos, 4000.0));
		leilao.propoe(new Lance(giovana, 5000.0));
		
		leilao.propoe(new Lance(joseCarlos, 6000.0));
		leilao.propoe(new Lance(giovana, 7000.0));
		
		leilao.propoe(new Lance(joseCarlos, 9000.0));
		leilao.propoe(new Lance(giovana, 9500.0));

		leilao.dobrarLance(joseCarlos);
		leilao.dobrarLance(giovana);
		
		leilao.dobrarLance(joseCarlos);
		leilao.dobrarLance(giovana);
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(18000.0, leilao.getLances().get(8).getValor(), 0.00001);
		assertEquals(19000.0, leilao.getLances().get(9).getValor(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarValorMenorQue0() {
		Usuario joseCarlos = new Usuario("José Carlos");
		
		Leilao leilao = new CriadorDeLeilao().para("Teste de lance negativo")
				.lance(joseCarlos, -1000.0)
				.constroi();
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarValorIgualA0() {
		Usuario joseCarlos = new Usuario("José Carlos");
		
		Leilao leilao = new CriadorDeLeilao().para("Teste de lance negativo")
				.lance(joseCarlos, 0)
				.constroi();
	}
}
