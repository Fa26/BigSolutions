/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 * Clase para trabajar con usuarios.
 * @author leo
 */
public class Usuario extends Control{
    
    private Integer nIdUsuario;
    private String usuario;
    private String nombre;
    private String app;
    private String apm;
    private String correo;
    private String contrasenia;
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
   
    public int setUsuario(String nombre, String app, String apm, String correo, String contraseña ) throws Exception{
        int b = 0;
        b = conexionBD.setUsuario( nombre, app,  apm, correo,contraseña);
        return b;
    }
     
    // TODO: Agregar funcionalidad de subir foto.
    /*
    public byte[] getFoto() {
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
  
}
