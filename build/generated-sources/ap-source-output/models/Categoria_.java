package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Categoria;
import models.CategoriaProducto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Categoria> fkIdCategoria;
    public static volatile CollectionAttribute<Categoria, Categoria> categoriaCollection;
    public static volatile SingularAttribute<Categoria, String> valor;
    public static volatile CollectionAttribute<Categoria, CategoriaProducto> categoriaProductoCollection;
    public static volatile SingularAttribute<Categoria, Integer> id;
    public static volatile SingularAttribute<Categoria, Boolean> activo;

}