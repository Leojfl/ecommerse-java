package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.CategoriaProducto;
import models.Imagen;
import models.ProductoOrden;
import models.PropiedadProducto;
import models.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile CollectionAttribute<Producto, Imagen> imagenCollection;
    public static volatile SingularAttribute<Producto, Usuario> fkIdUsuario;
    public static volatile CollectionAttribute<Producto, PropiedadProducto> propiedadProductoCollection;
    public static volatile CollectionAttribute<Producto, CategoriaProducto> categoriaProductoCollection;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile CollectionAttribute<Producto, ProductoOrden> productoOrdenCollection;
    public static volatile SingularAttribute<Producto, Boolean> activo;

}