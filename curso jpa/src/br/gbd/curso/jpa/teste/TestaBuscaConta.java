package br.gbd.curso.jpa.teste;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.util.JPAUtil;

public class TestaBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		conta.setTitular("João Carlos");
		conta.setNumero("123345");
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
		em.close();
	}
}
