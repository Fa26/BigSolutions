/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "Administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByNIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.nIdAdministrador = :nIdAdministrador")
    , @NamedQuery(name = "Administrador.findByUsuario", query = "SELECT a FROM Administrador a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo")
    , @NamedQuery(name = "Administrador.findByContrasenia", query = "SELECT a FROM Administrador a WHERE a.contrasenia = :contrasenia")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIdAdministrador")
    private Integer nIdAdministrador;
    @Size(max = 64)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 128)
    @Column(name = "correo")
    private String correo;
    @Size(max = 128)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(mappedBy = "nIdAdministrador")
    private List<Puesto> puestoList;

    public Administrador() {
    }

    public Administrador(Integer nIdAdministrador) {
        this.nIdAdministrador = nIdAdministrador;
    }

    public Integer getNIdAdministrador() {
        return nIdAdministrador;
    }

    public void setNIdAdministrador(Integer nIdAdministrador) {
        this.nIdAdministrador = nIdAdministrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdAdministrador != null ? nIdAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.nIdAdministrador == null && other.nIdAdministrador != null) || (this.nIdAdministrador != null && !this.nIdAdministrador.equals(other.nIdAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Administrador[ nIdAdministrador=" + nIdAdministrador + " ]";
    }
    
}
