package br.com.gbd.alura.daos;

import br.com.gbd.alura.models.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
    Autor(es): José Carlos de Freitas
    Data: 05/03/2017 às 13:52:26
    Arquivo: ProdutoDAO
 */

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> listar() {
        return manager.createQuery(" from Produto", Produto.class).getResultList();
    }

    public Produto find(int id) {
        return manager.createQuery("Select p from Produto p join fetch p.precos "
                + "where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
