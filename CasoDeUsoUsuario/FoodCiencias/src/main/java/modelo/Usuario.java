/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNIdUsuario", query = "SELECT u FROM Usuario u WHERE u.nIdUsuario = :nIdUsuario")
    , @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApp", query = "SELECT u FROM Usuario u WHERE u.app = :app")
    , @NamedQuery(name = "Usuario.findByApm", query = "SELECT u FROM Usuario u WHERE u.apm = :apm")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIdUsuario")
    private Integer nIdUsuario;
    @Size(max = 64)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 64)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 64)
    @Column(name = "app")
    private String app;
    @Size(max = 63)
    @Column(name = "apm")
    private String apm;
    @Size(max = 128)
    @Column(name = "correo")
    private String correo;
    @Size(max = 128)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Usuario() {
    }

    public Usuario(Integer nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    public Integer getNIdUsuario() {
        return nIdUsuario;
    }

    public void setNIdUsuario(Integer nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
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

    
   
    
    // en lo que puedo subir la foto
    /*public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdUsuario != null ? nIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nIdUsuario == null && other.nIdUsuario != null) || (this.nIdUsuario != null && !this.nIdUsuario.equals(other.nIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Usuario[ nIdUsuario=" + nIdUsuario + " ]";
    }

    public void setFoto(String foto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
