/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import Otros.UsuarioBean;

import control.exceptions.NonexistentEntityException;

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
import control.UsuarioJpaController;
import entidad.Usuario;
/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class EliminaUsuarioC implements Serializable{
    
 
    
     EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
   
  
    private Usuario select;
    private List<UsuarioBean> selectP;
    

 
    public EliminaUsuarioC(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
    }
  
   public Usuario getSelect(){
        return this.select;
   }
   public void setSelect(Usuario selectP){
       this.select=selectP;
   }
   public List<UsuarioBean> getSelecte(){
       return this.selectP;
   }
   public void setSelecte(List<UsuarioBean> seleP){
       this.selectP=seleP;
   }
   
   public void elimina(){
      
     
        UsuarioJpaController elimina = new UsuarioJpaController(emf);
        try{
        elimina.destroy(select.getNIdUsuario());
        select=null;
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades, se borro correctamente", ""));
        }catch(NonexistentEntityException ex){
             ex.printStackTrace();
        }
   
   }
    
}
