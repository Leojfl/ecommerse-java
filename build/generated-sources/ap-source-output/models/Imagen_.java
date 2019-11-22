package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(Imagen.class)
public class Imagen_ { 

    public static volatile SingularAttribute<Imagen, Producto> fkIdProducto;
    public static volatile SingularAttribute<Imagen, Integer> id;
    public static volatile SingularAttribute<Imagen, String> url;

}