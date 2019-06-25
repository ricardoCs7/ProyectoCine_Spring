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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "sala")
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre_Sala")
    private String nombreSala;
    @JoinColumn(name = "Funcionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcion funcionid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private List<Asiento> asientoList;

    public Sala() {
    }

    public Sala(Integer id) {
        this.id = id;
    }

    public Sala(Integer id, String nombreSala) {
        this.id = id;
        this.nombreSala = nombreSala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Funcion getFuncionid() {
        return funcionid;
    }

    public void setFuncionid(Funcion funcionid) {
        this.funcionid = funcionid;
    }

    public List<Asiento> getAsientoList() {
        return asientoList;
    }

    public void setAsientoList(List<Asiento> asientoList) {
        this.asientoList = asientoList;
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
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.proyectoCine.ProyectoCine.modelo.Sala[ id=" + id + " ]";
    }
    
}
