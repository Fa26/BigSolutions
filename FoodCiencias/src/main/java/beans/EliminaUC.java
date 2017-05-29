/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Otros.PuestoBean;
import Otros.UsuarioBean;
import control.PuestoJpaController;
import control.UsuarioJpaController;
import entidad.Usuario;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidad.Administrador;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class EliminaUC implements Serializable{
    
    
     EntityManagerFactory emf = 
     Persistence.createEntityManagerFactory("FoodCienciasPU");
     
     private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
      private final FacesContext faceContext; // Obtiene información de la aplicación
      private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
      private HttpSession sesion;
      private HttpServletResponse response;

     
    private List<Usuario> usuario;
    private List<UsuarioBean> upb;
    
  
    public EliminaUC() throws IOException{
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if(inicioSesion() == false){
             faceContext.getExternalContext().redirect("PaginaPrincipal.xhtml");
        }
    
    }
    
     @PostConstruct
    public void init(){
        usuario = new LinkedList();
        upb = new LinkedList();
        
        UsuarioJpaController user = new UsuarioJpaController(emf);
        usuario=user.findUsuarioEntities();
        
        for(int i=0; i<usuario.size();i++){
            UsuarioBean ub = new UsuarioBean(usuario.get(i).getNIdUsuario(),
                usuario.get(i).getUsuario(),
                usuario.get(i).getCorreo(),
                usuario.get(i).getContrasenia(),
                usuario.get(i).getNombre(),
                usuario.get(i).getApp(),
                usuario.get(i).getApm(),
                usuario.get(i).getFoto());
            
            upb.add(ub);
        }
    }//fin del metodo init
    
    public void setUsu(List usuario){
        this.usuario=usuario;
    }
    public List getUsu(){
        return this.usuario;
    }
    
    public int total(){
        return this.upb.size();
    }
  
    public Administrador getAdminstrador(){
       Administrador administrador = (Administrador) httpServletRequest.getSession().getAttribute("sessionUsuario");
       return administrador;
        
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



    public final  boolean inicioSesion(){
        sesion = httpServletRequest.getSession(false);
        return sesion != null && sesion.getAttribute("sessionUsuario") != null;
    }
  
  
    
    
}//fin de la clase EliminaUC
