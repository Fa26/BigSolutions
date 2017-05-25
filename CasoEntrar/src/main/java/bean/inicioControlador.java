/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import entidad.Usuario;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carloazul21
 */
@ManagedBean (name = "inicio")// LEER LA DOCUMENTACIÖN DE ESTA ANOTACIÓN: Permite dar de alta al bean en la aplicación
@RequestScoped // Sólo está disponible a partir de peticiones al bean
public class inicioControlador {
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private HttpSession sesion;
    private HttpServletResponse response;


public inicioControlador() throws IOException{
  faceContext = FacesContext.getCurrentInstance();
  httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
  if(inicioSesion() == false){
         faceContext.getExternalContext().redirect("Entrar.xhtml");
  }  
    
}

    public Usuario getUsuario(){
       Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute("sessionUsuario");
       return usuario;
        
    }


    public FacesMessage getMessage() {
        return message;
    }

    public void setMessage(FacesMessage message) {
        this.message = message;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    
public String saludo(){
    return "Bienvenido a la pagina";
}



public final boolean inicioSesion(){
    sesion = httpServletRequest.getSession(false);
    return sesion != null && sesion.getAttribute("sessionUsuario") != null;
}

}