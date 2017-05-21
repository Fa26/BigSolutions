/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Otros.ComentarioBean;
import control.ComentarioJpaController;
import control.PuestoJpaController;
import control.exceptions.NonexistentEntityException;
import entidad.Comentario;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class EliminaComen implements Serializable{
    
    
      EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
      
       private Comentario select;
       private List<ComentarioBean> selectP;
      
      public EliminaComen(){
      
             FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
      }
      
       public Comentario getSelect(){
        return this.select;
   }
   public void setSelect(Comentario selectP){
       this.select=selectP;
   }
   public List<ComentarioBean> getSelecte(){
       return this.selectP;
   }
   public void setSelecte(List<ComentarioBean> seleP){
       this.selectP=seleP;
   }
   
   
   
    public void elimina(){
      
     
        ComentarioJpaController elimina = new ComentarioJpaController(emf);
        try{
        elimina.destroy(select.getNIdComentario());
        select=null;
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades, se borro correctamente", ""));
        }catch(NonexistentEntityException ex){
             ex.printStackTrace();
        }
   
   }
    
}//fin de la clase EliminaComen
