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
@Table(name = "categoria", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findById", query = "SELECT c FROM Categoria c WHERE c.id = :id")
    , @NamedQuery(name = "Categoria.findByValor", query = "SELECT c FROM Categoria c WHERE c.valor = :valor")
    , @NamedQuery(name = "Categoria.findByActivo", query = "SELECT c FROM Categoria c WHERE c.activo = :activo")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCategoria")
    private Collection<CategoriaProducto> categoriaProductoCollection;
    @OneToMany(mappedBy = "fkIdCategoria")
    private Collection<Categoria> categoriaCollection;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria fkIdCategoria;

    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String valor, boolean activo) {
        this.id = id;
        this.valor = valor;
        this.activo = activo;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<CategoriaProducto> getCategoriaProductoCollection() {
        return categoriaProductoCollection;
    }

    public void setCategoriaProductoCollection(Collection<CategoriaProducto> categoriaProductoCollection) {
        this.categoriaProductoCollection = categoriaProductoCollection;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    public Categoria getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(Categoria fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Categoria[ id=" + id + " ]";
    }
    
}
