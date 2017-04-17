package br.gbd.curso.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.modelo.Movimentacao;
import br.gbd.curso.jpa.util.JPAUtil;

public class TesteInserirMovimentacao {
	public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();


        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }
        em.close();

    }
}
