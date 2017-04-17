package br.gbd.curso.jpa.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Categoria;
import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.modelo.Movimentacao;
import br.gbd.curso.jpa.modelo.TipoMovimentacao;
import br.gbd.curso.jpa.util.JPAUtil;

public class TesteMovimentacaoComCategoria {

	public static void main(String[] args) {

		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2);

		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.0"));
		movimentacao1.setCategoria(Arrays.asList(cat1, cat2));
		
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem à RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategoria(Arrays.asList(cat1, cat2));
		
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();

		em.persist(cat1);
		em.persist(cat2);

		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}
}
