package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orden;
import models.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(ProductoOrden.class)
public class ProductoOrden_ { 

    public static volatile SingularAttribute<ProductoOrden, Producto> fkIdProducto;
    public static volatile SingularAttribute<ProductoOrden, Double> precio;
    public static volatile SingularAttribute<ProductoOrden, Orden> fkIdOrden;
    public static volatile SingularAttribute<ProductoOrden, Integer> id;
    public static volatile SingularAttribute<ProductoOrden, Integer> cantidad;

}