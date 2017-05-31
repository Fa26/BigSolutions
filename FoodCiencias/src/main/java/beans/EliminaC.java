/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Otros.PuestoBean;
import control.PuestoJpaController;
import control.exceptions.NonexistentEntityException;
import entidad.Puesto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.primefaces.event.SelectEvent;

import control.PuestoJpaController;
import javax.faces.component.UIComponent;
/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class EliminaC  implements Serializable{
    
 
    
     EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
   
  
    private Puesto select;
    private List<PuestoBean> selectP;
    

 
    public EliminaC(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
    }
  
   public Puesto getSelect(){
        return this.select;
   }
   public void setSelect(Puesto selectP){
       this.select=selectP;
   }
   public List<PuestoBean> getSelecte(){
       return this.selectP;
   }
   public void setSelecte(List<PuestoBean> seleP){
       this.selectP=seleP;
   }
   
   public void elimina(){
      
     
        PuestoJpaController elimina = new PuestoJpaController(emf);
        try{
        elimina.destroy(select.getNIdPuesto());
        select=null;
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades, se borro correctamente", ""));
        }catch(NonexistentEntityException ex){
             ex.printStackTrace();
        }
   
   }
   
   
    
}
