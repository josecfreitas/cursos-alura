package br.gbd.curso.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.util.JPAUtil;

public class TestaTodasMovimentacoesContas {

	public static void main(String[] args) {
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager em = jpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		Query query = em.createQuery("SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes", Conta.class);
		
		List<Conta> contas = query.getResultList();
		
		for(Conta conta : contas){
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		
		em.close();
		jpaUtil.close();
	}
}
