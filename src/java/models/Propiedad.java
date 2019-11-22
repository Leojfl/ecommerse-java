/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "propiedad", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p")
    , @NamedQuery(name = "Propiedad.findById", query = "SELECT p FROM Propiedad p WHERE p.id = :id")
    , @NamedQuery(name = "Propiedad.findByValor", query = "SELECT p FROM Propiedad p WHERE p.valor = :valor")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "valor")
    private String valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPropiedad")
    private Collection<PropiedadProducto> propiedadProductoCollection;

    public Propiedad() {
    }

    public Propiedad(Integer id) {
        this.id = id;
    }

    public Propiedad(Integer id, String valor) {
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
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Propiedad[ id=" + id + " ]";
    }
    
}
