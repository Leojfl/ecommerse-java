package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Producto;
import models.Propiedad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(PropiedadProducto.class)
public class PropiedadProducto_ { 

    public static volatile SingularAttribute<PropiedadProducto, Producto> fkIdProducto;
    public static volatile SingularAttribute<PropiedadProducto, Propiedad> fkIdPropiedad;
    public static volatile SingularAttribute<PropiedadProducto, String> valor;
    public static volatile SingularAttribute<PropiedadProducto, Integer> id;

}