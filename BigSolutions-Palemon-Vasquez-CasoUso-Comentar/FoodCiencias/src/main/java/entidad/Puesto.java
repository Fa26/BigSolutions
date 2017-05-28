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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FaVenegas
 */
@Entity
@Table(name = "Puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")
    , @NamedQuery(name = "Puesto.findByNIdPuesto", query = "SELECT p FROM Puesto p WHERE p.nIdPuesto = :nIdPuesto")
    , @NamedQuery(name = "Puesto.findByHoraApertura", query = "SELECT p FROM Puesto p WHERE p.horaApertura = :horaApertura")
    , @NamedQuery(name = "Puesto.findByHoraCierre", query = "SELECT p FROM Puesto p WHERE p.horaCierre = :horaCierre")
    , @NamedQuery(name = "Puesto.findByTipoComida", query = "SELECT p FROM Puesto p WHERE p.tipoComida = :tipoComida")
    , @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Puesto.findByNomDuenio", query = "SELECT p FROM Puesto p WHERE p.nomDuenio = :nomDuenio")
    , @NamedQuery(name = "Puesto.findByAppDuenio", query = "SELECT p FROM Puesto p WHERE p.appDuenio = :appDuenio")
    , @NamedQuery(name = "Puesto.findByApmDuenio", query = "SELECT p FROM Puesto p WHERE p.apmDuenio = :apmDuenio")})
public class Puesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIdPuesto")
    private Integer nIdPuesto;
    @Size(max = 12)
    @Column(name = "hora_apertura")
    private String horaApertura;
    @Size(max = 12)
    @Column(name = "hora_cierre")
    private String horaCierre;
    @Size(max = 45)
    @Column(name = "tipo_comida")
    private String tipoComida;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "nom_duenio")
    private String nomDuenio;
    @Size(max = 45)
    @Column(name = "app_duenio")
    private String appDuenio;
    @Size(max = 45)
    @Column(name = "apm_duenio")
    private String apmDuenio;

    public Puesto() {
    }

    public Puesto(Integer nIdPuesto) {
        this.nIdPuesto = nIdPuesto;
    }

    public Integer getNIdPuesto() {
        return nIdPuesto;
    }

    public void setNIdPuesto(Integer nIdPuesto) {
        this.nIdPuesto = nIdPuesto;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomDuenio() {
        return nomDuenio;
    }

    public void setNomDuenio(String nomDuenio) {
        this.nomDuenio = nomDuenio;
    }

    public String getAppDuenio() {
        return appDuenio;
    }

    public void setAppDuenio(String appDuenio) {
        this.appDuenio = appDuenio;
    }

    public String getApmDuenio() {
        return apmDuenio;
    }

    public void setApmDuenio(String apmDuenio) {
        this.apmDuenio = apmDuenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdPuesto != null ? nIdPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.nIdPuesto == null && other.nIdPuesto != null) || (this.nIdPuesto != null && !this.nIdPuesto.equals(other.nIdPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Puesto[ nIdPuesto=" + nIdPuesto + " ]";
    }
    
}
