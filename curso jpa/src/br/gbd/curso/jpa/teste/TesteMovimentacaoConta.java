package br.gbd.curso.jpa.teste;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.modelo.Movimentacao;
import br.gbd.curso.jpa.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager em = jpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		Conta conta = movimentacao.getConta();
		
		
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		
		em.close();
		jpaUtil.close();
	}
}
