package br.com.gbd.alura.daos;

import br.com.gbd.alura.models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

/*
    Autor(es): José Carlos de Freitas
    Data: 30/03/2017 às 13:48:37
    Arquivo: UsuarioDAO
 */
@Repository
public class UsuarioDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public UserDetails loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("O usuário " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }
}
