package br.gbd.curso.jpa.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.gbd.curso.jpa.modelo.Conta;
import br.gbd.curso.jpa.util.JPAUtil;

public class TestaFuncoesJPQL {
	public static void main(String[] args) {
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager em = jpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Double> query = em.createQuery("SELECT DISTINCT AVG(m.valor) FROM Movimentacao m GROUP BY m.data", Double.class);
		List<Double> medias = query.getResultList();
		
		for(Double media : medias){
			System.out.println(media);
		}
		
		em.getTransaction().commit();
		
		em.close();
		jpaUtil.close();
	}
}
