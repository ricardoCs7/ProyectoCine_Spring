/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.modelo;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "pelicula")
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 40)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "Categoriaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoriaid;
    @JoinColumn(name = "Idiomaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Idioma idiomaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private List<Funcion> funcionList;

    public Pelicula() {
    }

    public Pelicula(String titulo, Categoria categoriaid, Idioma idiomaid) {
        this.titulo = titulo;
        this.categoriaid = categoriaid;
        this.idiomaid = idiomaid;
    }

      
    
    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

    public Idioma getIdiomaid() {
        return idiomaid;
    }

    public void setIdiomaid(Idioma idiomaid) {
        this.idiomaid = idiomaid;
    }

    public List<Funcion> getFuncionList() {
        return funcionList;
    }

    public void setFuncionList(List<Funcion> funcionList) {
        this.funcionList = funcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titulo != null ? titulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.titulo == null && other.titulo != null) || (this.titulo != null && !this.titulo.equals(other.titulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.proyectoCine.ProyectoCine.modelo.Pelicula[ titulo=" + titulo + " ]";
    }
    
}
