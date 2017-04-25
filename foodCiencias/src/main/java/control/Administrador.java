/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author carloazul21
 */
@Named(value = "Administrador")
@Dependent
public class Administrador {
    
    int nIdAdministrador;
    String usuario;
    String correo;
    String contrasenia;

    public int getnIdAdministrador() {
        return nIdAdministrador;
    }

    public void setnIdAdministrador(int nIdAdministrador) {
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

    /**
     * Creates a new instance of Administrador
     */
    
    
}
