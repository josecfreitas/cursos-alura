package br.gbd.curso.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoJpa");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(){
		emf.close();
	}
}
