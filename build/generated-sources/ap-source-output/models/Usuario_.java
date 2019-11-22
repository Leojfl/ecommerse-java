package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orden;
import models.Producto;
import models.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T20:58:14")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> alias;
    public static volatile SingularAttribute<Usuario, Rol> fkIdRol;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile CollectionAttribute<Usuario, Producto> productoCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> username;
    public static volatile SingularAttribute<Usuario, Boolean> activo;
    public static volatile CollectionAttribute<Usuario, Orden> ordenCollection;

}