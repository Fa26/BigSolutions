/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import control.PuestoJpaController;
import entidad.Puesto;
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author FaVenegas
 */
@ManagedBean
@RequestScoped
public class EditaC {
 
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    PuestoJpaController pues = new PuestoJpaController(emf);

    private Puesto puesto = new Puesto();
   
    
     public EditaC() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));

    }
  

    public Puesto getPuesto() {
        return this.puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

     public void onRowEdit(RowEditEvent event) {
            try{
            Puesto puesE = (Puesto)event.getObject();
            pues.edit(puesE);
          int i = ((Puesto)event.getObject()).getNIdPuesto();
          String nid = Integer.toString(i);
        FacesMessage msg = new FacesMessage("Puesto Editado","Nid: "+nid);
        FacesContext.getCurrentInstance().addMessage(null, msg);
            }catch(Exception e){}
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cancelado el editar",null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
}//fin de la clase EditaC
