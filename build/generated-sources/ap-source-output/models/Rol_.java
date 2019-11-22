package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> valor;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile CollectionAttribute<Rol, Usuario> usuarioCollection;

}