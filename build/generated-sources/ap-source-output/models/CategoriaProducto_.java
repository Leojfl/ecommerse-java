package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Categoria;
import models.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(CategoriaProducto.class)
public class CategoriaProducto_ { 

    public static volatile SingularAttribute<CategoriaProducto, Categoria> fkIdCategoria;
    public static volatile SingularAttribute<CategoriaProducto, Producto> fkIdProducto;
    public static volatile SingularAttribute<CategoriaProducto, Integer> id;

}