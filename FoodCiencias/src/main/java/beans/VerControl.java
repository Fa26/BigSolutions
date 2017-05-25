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


/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class VerControl implements Serializable {
    
     EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
   
    private List<Puesto> puestos;
    private List<PuestoBean> pb;
    

 
    public VerControl(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
    }
    @PostConstruct
    public void init(){
        puestos = new LinkedList();
        pb=new LinkedList();
        PuestoJpaController ve = new PuestoJpaController(emf);
        puestos=ve.findPuestoEntities();
        
        for(int i=0; i<puestos.size();i++){
            PuestoBean pbean = new PuestoBean(puestos.get(i).getNIdPuesto(),
                    puestos.get(i).getHoraApertura(),
                    puestos.get(i).getHoraCierre(),
                    puestos.get(i).getTipoComida(),
                    puestos.get(i).getNombre(),
                    puestos.get(i).getNomDuenio(),
                    puestos.get(i).getAppDuenio(),
                    puestos.get(i).getApmDuenio());
           
            
          pb.add(pbean);
        }
    }
    
   public List getPuestos(){
       return this.puestos;
   }
   public void setPuestos(List puestos){
       this.puestos=puestos;
   }
   
   public int total(){
       return pb.size();
   }
   
  
   
  
   
    
    
   
    
}//termina la clase verControl
