package br.gbd.curso.jpa.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.modelo.Movimentacao;
import br.gbd.curso.jpa.modelo.TipoMovimentacao;
import br.gbd.curso.jpa.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("1234");
		conta.setBanco("Itau");
		conta.setNumero("123");
		conta.setTitular("Gabriel");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
