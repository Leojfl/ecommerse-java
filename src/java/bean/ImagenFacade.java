/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Imagen;

/**
 *
 * @author leojf
 */
@Stateless
public class ImagenFacade extends AbstractFacade<Imagen> {

    @PersistenceContext(unitName = "FinalProjectJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenFacade() {
        super(Imagen.class);
    }
    
}
