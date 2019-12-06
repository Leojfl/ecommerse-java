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
import models.Orden;
import models.Usuario;

/**
 *
 * @author leojf
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> {

    @PersistenceContext(unitName = "FinalProjectJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    
      public List<Orden> order(Usuario usu, int status) {
        return getEntityManager().createNamedQuery("Orden.clientStatatus")
               // .setParameter("userId", usu.getId())
                .setParameter("status", status)
                .getResultList();
    }
    
}
