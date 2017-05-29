/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import control.PuestoJpaController;
import entidad.Puesto;
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
@RequestScoped

public class PuestoControl {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
      PuestoJpaController pues = new PuestoJpaController(emf);
      
      private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
      private final FacesContext faceContext; // Obtiene información de la aplicación
      private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
      private HttpSession sesion;
      private HttpServletResponse response;

    private Puesto puesto = new Puesto();
    
    public PuestoControl() throws  IOException{
          FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
          faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if(inicioSesion() == false){
             faceContext.getExternalContext().redirect("PaginaPrincipal.xhtml");
        }
    }
    
     public Puesto getPuesto() {
        return this.puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
     public boolean fecha(String fecha){
        try{
         SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
               formatter.setLenient(false);
               formatter.parse(puesto.getHoraApertura());
        }catch(Exception e){
            return false;
        }
        return true;
    }
      public void addPuesto() {
               Puesto p = new Puesto();
           
               try{
                   if(fecha(puesto.getHoraApertura()) == false){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Verifica la Hora que sea formato: 12:00",""));
                   }else if(fecha(puesto.getHoraCierre()) == false){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Verifica la Hora",""));
                   }else{
               p.setHoraApertura(puesto.getHoraApertura());
               p.setHoraCierre(puesto.getHoraCierre());
               p.setTipoComida(puesto.getTipoComida());
               p.setNombre(puesto.getNombre());
               p.setNomDuenio(puesto.getNomDuenio());
               p.setAppDuenio(puesto.getAppDuenio());
               p.setApmDuenio(puesto.getApmDuenio());
               
               
               pues.create(p);
               
               FacesContext.getCurrentInstance().addMessage(null,
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades, el registro se ha realizado correctamente", ""));
                   } 
           } catch (Exception ex) {
               ex.printStackTrace();
           }
           
      
    }//fin add Puesto
      
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



    public  boolean inicioSesion(){
        sesion = httpServletRequest.getSession(false);
        return sesion != null && sesion.getAttribute("sessionUsuario") != null;
    }
  
}//fin de la calse PuestoControl
