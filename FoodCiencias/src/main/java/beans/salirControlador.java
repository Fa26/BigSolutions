/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import entidad.*;

/**
 *
 * @author carloazul21
 */
@ManagedBean (name = "salir")// LEER LA DOCUMENTACIÖN DE ESTA ANOTACIÓN: Permite dar de alta al bean en la aplicación
@RequestScoped // Sólo está disponible a partir de peticiones al bean
public class salirControlador {
    
    private Usuario usuario; // Representa el nombre de usuario.
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.

    
    public salirControlador(){
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            usuario = (Usuario)httpServletRequest.getSession().getAttribute("sessionUsuario");
        }        
    }
    
     /**
     * Método encargado de cerrar la sesión de la aplicación.
     *
     * @return El nombre de la vista que va a responder.
     */
    public String cerrarSession() {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        // httpServletRequest.getSession().destroy();
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, message);
        return "PaginaPrincipal";
    }

    /**
     * Regresa el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nombre de usuario a establecer.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
    
