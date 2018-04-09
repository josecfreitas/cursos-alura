package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	private Avaliador avaliador;

	private Usuario jose;
	private Usuario giovana;

	private Usuario vitu;

	@Before
	public void setUp() {
		this.avaliador = new Avaliador();

		this.jose = new Usuario("José Carlos");
		this.giovana = new Usuario("Giovana");
		this.vitu = new Usuario("Vitu");
	}

	@After
	public void finaliza() {
	}

	@Test
	public void testaLancesDeFormaCrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 250.0)
				.lance(giovana, 400.0)
				.lance(jose, 550.0)
				.constroi();

		// #2 - Ação
		avaliador.avalia(leilao);

		// #3 - Validação
		assertEquals(250.0, avaliador.getMenorLance(), 0.0001);
		assertEquals(550.0, avaliador.getMaiorLance(), 0.0001);
		assertEquals(400.0, avaliador.getValorMedio(), 0.0001);
	}

	@Test
	public void testaLancesDeFormaDecrescente() {
		// #1 - Cenário
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 400.0)
				.lance(giovana, 300.0)
				.lance(jose, 200.0)
				.lance(giovana, 100.0)
				.constroi();

		avaliador.avalia(leilao);

		// #3 - Validação
		assertEquals(100.0, avaliador.getMenorLance(), 0.0001);
		assertEquals(400.0, avaliador.getMaiorLance(), 0.0001);
		assertEquals(250.0, avaliador.getValorMedio(), 0.0001);
	}

	@Test
	public void testaApenasUmLanceNoLeilao() {
		// #1 - Cenário
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 100.0)
				.constroi();

		avaliador.avalia(leilao);

		// #3 - Validação
		assertEquals(100.0, avaliador.getMaiorLance(), 0.0001);
		assertEquals(100.0, avaliador.getMenorLance(), 0.0001);
		assertEquals(100.0, avaliador.getValorMedio(), 0.0001);
	}

	@Test
	public void testaLancesDeFormaAleatoria() {
		// #1 - Cenário
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 200.0)
				.lance(giovana, 450.0)
				.lance(jose, 120.0)
				.lance(vitu, 700.0)
				.lance(giovana, 630.0)
				.lance(jose, 230.0)
				.constroi();

		avaliador.avalia(leilao);

		// #3 - Validação
		assertEquals(120.0, avaliador.getMenorLance(), 0.0001);
		assertEquals(700.0, avaliador.getMaiorLance(), 0.0001);
		assertEquals(388.3, avaliador.getValorMedio(), 0.9);
	}

	@Test
	public void testaEncontrarMaioresLancesEm5() {
		// #1 - Cenário
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 200.0)
				.lance(giovana, 450.0)
				.lance(jose, 120.0)
				.lance(vitu, 700.0)
				.lance(giovana, 630.0)
				.constroi();

		avaliador.avalia(leilao);

		// #3 - Validação
		List<Lance> tresMaioresLances = avaliador.getTresMaiores();
		assertEquals(3, tresMaioresLances.size());
		assertEquals(700.0, tresMaioresLances.get(0).getValor(), 0.0001);
		assertEquals(630.0, tresMaioresLances.get(1).getValor(), 0.0001);
		assertEquals(450.0, tresMaioresLances.get(2).getValor(), 0.0001);
	}

	@Test
	public void testaEncontrarMaioresLancesEm2() {
		// #1 - Cenário
		Leilao leilao = new CriadorDeLeilao().para("Leilão de testes")
				.lance(jose, 200.0)
				.lance(giovana, 450.0)
				.constroi();

		avaliador.avalia(leilao);

		// #3 - Validação
		List<Lance> tresMaioresLances = avaliador.getTresMaiores();
		assertEquals(2, tresMaioresLances.size());
		assertEquals(450.0, tresMaioresLances.get(0).getValor(), 0.0001);
		assertEquals(200.0, tresMaioresLances.get(1).getValor(), 0.0001);
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeilaoSemLance() {
		Leilao leilao = new Leilao("Leilão sem lance");
		
		avaliador.avalia(leilao);
	}
}
