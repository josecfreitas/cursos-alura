package br.gbd.curso.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gbd.curso.jpa.modelo.Categoria;
import br.gbd.curso.jpa.modelo.Movimentacao;
import br.gbd.curso.jpa.modelo.TipoMovimentacao;
import br.gbd.curso.jpa.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager em = jpaUtil.getEntityManager();

		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(2);

//		Query query = em.createQuery("SELECT m FROM Movimentacao m WHERE "
//				+ " m.conta.id = :pConta and m.tipo = :pTipo ORDER BY m.valor desc")
//				.setParameter("pConta", 2)
//				.setParameter("pTipo", TipoMovimentacao.SAIDA);
		Query query = em.createQuery("SELECT m FROM Movimentacao m join m.categoria c WHERE c = :pCategoria")
		.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();

		for(Movimentacao m : resultados){
			System.out.println(m.getDescricao());
			System.out.println(m.getId());
		}
		
		em.getTransaction().commit();
		em.close();
		jpaUtil.close();
	}
}
