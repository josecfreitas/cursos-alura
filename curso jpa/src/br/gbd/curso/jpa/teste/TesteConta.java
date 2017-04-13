package br.gbd.curso.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gbd.curso.jpa.modelo.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("José Carlos");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoJpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
