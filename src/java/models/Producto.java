/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leojf
 */
@Entity
@Table(name = "producto", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByActivo", query = "SELECT p FROM Producto p WHERE p.activo = :activo")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdProducto")
    private Collection<ProductoOrden> productoOrdenCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdProducto")
    private Collection<CategoriaProducto> categoriaProductoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdProducto")
    private Collection<Imagen> imagenCollection;

    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario fkIdUsuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdProducto")
    private Collection<PropiedadProducto> propiedadProductoCollection;

    public Producto() {

    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, double precio, int cantidad, boolean activo, String descripcion, String nombre) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Imagen getImage() {

        Iterator<Imagen> it = imagenCollection.iterator();
        Imagen img = null;
        while (it.hasNext()) {
            img = it.next();
        }
        return img;
    }

    public ArrayList<Imagen> getImages() {

        Iterator<Imagen> it = imagenCollection.iterator();
        ArrayList list = new ArrayList();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ProductoOrden> getProductoOrdenCollection() {
        return productoOrdenCollection;
    }

    public void setProductoOrdenCollection(Collection<ProductoOrden> productoOrdenCollection) {
        this.productoOrdenCollection = productoOrdenCollection;
    }

    @XmlTransient
    public Collection<CategoriaProducto> getCategoriaProductoCollection() {
        return categoriaProductoCollection;
    }

    public void setCategoriaProductoCollection(Collection<CategoriaProducto> categoriaProductoCollection) {
        this.categoriaProductoCollection = categoriaProductoCollection;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection() {
        return imagenCollection;
    }

    public void setImagenCollection(Collection<Imagen> imagenCollection) {
        this.imagenCollection = imagenCollection;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @XmlTransient
    public Collection<PropiedadProducto> getPropiedadProductoCollection() {
        return propiedadProductoCollection;
    }

    public void setPropiedadProductoCollection(Collection<PropiedadProducto> propiedadProductoCollection) {
        this.propiedadProductoCollection = propiedadProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Producto[ id=" + id + " ]";
    }

}
