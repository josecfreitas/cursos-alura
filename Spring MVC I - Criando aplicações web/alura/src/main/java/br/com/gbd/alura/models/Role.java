package br.com.gbd.alura.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

/*
    Autor(es): José Carlos de Freitas
    Data: 30/03/2017 às 13:57:50
    Arquivo: Role
 */
@Entity
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
