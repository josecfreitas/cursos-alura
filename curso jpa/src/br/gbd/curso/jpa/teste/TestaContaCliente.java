package br.gbd.curso.jpa.teste;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Cliente;
import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setEndereco("Leonardo");
		cliente.setEndereco("Rua x, 123");
		cliente.setProfissao("Programador");

		Conta conta = new Conta();
		conta.setId(2);

		cliente.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}
}
