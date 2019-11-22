/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leojf
 */
@Entity
@Table(name = "producto_orden", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoOrden.findAll", query = "SELECT p FROM ProductoOrden p")
    , @NamedQuery(name = "ProductoOrden.findById", query = "SELECT p FROM ProductoOrden p WHERE p.id = :id")
    , @NamedQuery(name = "ProductoOrden.findByCantidad", query = "SELECT p FROM ProductoOrden p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProductoOrden.findByPrecio", query = "SELECT p FROM ProductoOrden p WHERE p.precio = :precio")})
public class ProductoOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "fk_id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto fkIdProducto;
    @JoinColumn(name = "fk_id_orden", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orden fkIdOrden;

    public ProductoOrden() {
    }

    public ProductoOrden(Integer id) {
        this.id = id;
    }

    public ProductoOrden(Integer id, int cantidad, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getFkIdProducto() {
        return fkIdProducto;
    }

    public void setFkIdProducto(Producto fkIdProducto) {
        this.fkIdProducto = fkIdProducto;
    }

    public Orden getFkIdOrden() {
        return fkIdOrden;
    }

    public void setFkIdOrden(Orden fkIdOrden) {
        this.fkIdOrden = fkIdOrden;
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
        if (!(object instanceof ProductoOrden)) {
            return false;
        }
        ProductoOrden other = (ProductoOrden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ProductoOrden[ id=" + id + " ]";
    }
    
}
