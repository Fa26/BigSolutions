/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "Calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByNIdUsuario", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.nIdUsuario = :nIdUsuario")
    , @NamedQuery(name = "Calificacion.findByNIdPuesto", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.nIdPuesto = :nIdPuesto")
    , @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    @Column(name = "calificacion")
    private Integer calificacion;
    @JoinColumn(name = "nIdUsuario", referencedColumnName = "nIdUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "nIdPuesto", referencedColumnName = "nIdPuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Puesto puesto;

    public Calificacion() {
    }

    public Calificacion(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Calificacion(int nIdUsuario, int nIdPuesto) {
        this.calificacionPK = new CalificacionPK(nIdUsuario, nIdPuesto);
    }

    public CalificacionPK getCalificacionPK() {
        return calificacionPK;
    }

    public void setCalificacionPK(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionPK != null ? calificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionPK == null && other.calificacionPK != null) || (this.calificacionPK != null && !this.calificacionPK.equals(other.calificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Calificacion[ calificacionPK=" + calificacionPK + " ]";
    }
    
}
