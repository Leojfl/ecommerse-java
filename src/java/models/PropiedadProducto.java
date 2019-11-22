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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leojf
 */
@Entity
@Table(name = "propiedad_producto", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropiedadProducto.findAll", query = "SELECT p FROM PropiedadProducto p")
    , @NamedQuery(name = "PropiedadProducto.findById", query = "SELECT p FROM PropiedadProducto p WHERE p.id = :id")
    , @NamedQuery(name = "PropiedadProducto.findByValor", query = "SELECT p FROM PropiedadProducto p WHERE p.valor = :valor")})
public class PropiedadProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "fk_id_propiedad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Propiedad fkIdPropiedad;
    @JoinColumn(name = "fk_id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto fkIdProducto;

    public PropiedadProducto() {
    }

    public PropiedadProducto(Integer id) {
        this.id = id;
    }

    public PropiedadProducto(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Propiedad getFkIdPropiedad() {
        return fkIdPropiedad;
    }

    public void setFkIdPropiedad(Propiedad fkIdPropiedad) {
        this.fkIdPropiedad = fkIdPropiedad;
    }

    public Producto getFkIdProducto() {
        return fkIdProducto;
    }

    public void setFkIdProducto(Producto fkIdProducto) {
        this.fkIdProducto = fkIdProducto;
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
        if (!(object instanceof PropiedadProducto)) {
            return false;
        }
        PropiedadProducto other = (PropiedadProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PropiedadProducto[ id=" + id + " ]";
    }
    
}
