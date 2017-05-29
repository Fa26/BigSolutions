/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import Otros.PuestoBean;

import control.PuestoJpaController;

import entidad.Puesto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidad.Puesto;
import entidad.Administrador;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.faces.application.FacesMessage;




/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class VerControl implements Serializable {
    
     EntityManagerFactory emf = 
     Persistence.createEntityManagerFactory("FoodCienciasPU");
     
     private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
      private final FacesContext faceContext; // Obtiene información de la aplicación
      private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
      private HttpSession sesion;
      private HttpServletResponse response;

     
    private List<Puesto> puestos;
    private List<PuestoBean> pb;
    //Alimentos
    /*
    private List<Alimento> alimentos;
    private List<AlimentoBean> ali;
*/
 
    public VerControl() throws IOException{
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if(inicioSesion() == false){
             faceContext.getExternalContext().redirect("PaginaPrincipal.xhtml");
        }
    
    }
    @PostConstruct
    public void init(){
        puestos = new LinkedList();
        pb=new LinkedList();
        PuestoJpaController ve = new PuestoJpaController(emf);
        puestos=ve.findPuestoEntities();
        //alimentos
       /* alimentos = new LinkedList();
        ali= new LinkedList();
        AlimentoJpaController vea = new AlimentoJpaController(emf);
        alimentos =vea.findAlimentoEntities();*/
        
        
        
        for(int i=0; i<puestos.size();i++){
            PuestoBean pbean = new PuestoBean(puestos.get(i).getNIdPuesto(),
           
                    puestos.get(i).getHoraApertura(),
                    puestos.get(i).getHoraCierre(),
                    puestos.get(i).getTipoComida(),
                    puestos.get(i).getNombre(),
                    puestos.get(i).getNomDuenio(),
                    puestos.get(i).getAppDuenio(),
                    puestos.get(i).getApmDuenio());
        /* AlimentoBean abean = new AlimentoBean(alimentos.get(i).getNIdAlimento(),
                    alimentos.get(i).getNombreAlimento());*/
        // ali.add(abean);
          pb.add(pbean);
         //pb.add(pbean);
        
        }
    }
    
   public List getPuestos(){
       return this.puestos;
   }
   public void setPuestos(List puestos){
       this.puestos=puestos;
   }
   
   //Alimentos
 /*  public List getAlimentos(){
       return this.alimentos;
   }
   public void setAlimentos(List alimentos){
       this.alimentos=alimentos;
   }*/
   
   public int total(){
       return pb.size();
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
  
  
   
    
    
   
    
}//termina la clase verControl
