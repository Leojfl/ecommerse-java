/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Usuario;

/**
 *
 * @author leojf
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "FinalProjectJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public List<Usuario> validar(Usuario usu) {
        return getEntityManager().createNamedQuery("Usuario.validar")
                .setParameter("username", usu.getUsername())
                .setParameter("password", usu.getPassword())
                .getResultList();
    }

    public List<Usuario> validarUsername(Usuario usu) {
        return getEntityManager().createNamedQuery("Usuario.validarUsername")
                .setParameter("username", usu.getUsername())
                .getResultList();
    }

}
