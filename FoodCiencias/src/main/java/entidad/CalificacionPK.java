/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author leo
 */
@Embeddable
public class CalificacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdUsuario")
    private int nIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdPuesto")
    private int nIdPuesto;

    public CalificacionPK() {
    }

    public CalificacionPK(int nIdUsuario, int nIdPuesto) {
        this.nIdUsuario = nIdUsuario;
        this.nIdPuesto = nIdPuesto;
    }

    public int getNIdUsuario() {
        return nIdUsuario;
    }

    public void setNIdUsuario(int nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    public int getNIdPuesto() {
        return nIdPuesto;
    }

    public void setNIdPuesto(int nIdPuesto) {
        this.nIdPuesto = nIdPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nIdUsuario;
        hash += (int) nIdPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionPK)) {
            return false;
        }
        CalificacionPK other = (CalificacionPK) object;
        if (this.nIdUsuario != other.nIdUsuario) {
            return false;
        }
        if (this.nIdPuesto != other.nIdPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.CalificacionPK[ nIdUsuario=" + nIdUsuario + ", nIdPuesto=" + nIdPuesto + " ]";
    }
    
}
