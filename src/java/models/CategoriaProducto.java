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
@Table(name = "categoria_producto", catalog = "ecommercejava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c")
    , @NamedQuery(name = "CategoriaProducto.findById", query = "SELECT c FROM CategoriaProducto c WHERE c.id = :id")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria fkIdCategoria;
    @JoinColumn(name = "fk_id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto fkIdProducto;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(Categoria fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
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
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.CategoriaProducto[ id=" + id + " ]";
    }
    
}
