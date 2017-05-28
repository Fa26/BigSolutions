/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FaVenegas
 */
@Entity
@Table(name = "Alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a")
    , @NamedQuery(name = "Alimento.findByNIdAlimento", query = "SELECT a FROM Alimento a WHERE a.nIdAlimento = :nIdAlimento")
    , @NamedQuery(name = "Alimento.findByNombreAlimento", query = "SELECT a FROM Alimento a WHERE a.nombreAlimento = :nombreAlimento")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdAlimento")
    private Integer nIdAlimento;
    @Size(max = 90)
    @Column(name = "nombreAlimento")
    private String nombreAlimento;

    public Alimento() {
    }

    public Alimento(Integer nIdAlimento) {
        this.nIdAlimento = nIdAlimento;
    }

    public Integer getNIdAlimento() {
        return nIdAlimento;
    }

    public void setNIdAlimento(Integer nIdAlimento) {
        this.nIdAlimento = nIdAlimento;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdAlimento != null ? nIdAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.nIdAlimento == null && other.nIdAlimento != null) || (this.nIdAlimento != null && !this.nIdAlimento.equals(other.nIdAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Alimento[ nIdAlimento=" + nIdAlimento + " ]";
    }
    
}
