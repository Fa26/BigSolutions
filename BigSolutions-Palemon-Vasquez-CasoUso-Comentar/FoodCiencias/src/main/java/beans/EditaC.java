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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import control.PuestoJpaController;
import entidad.Puesto;
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
    
    public void editar(){
        
     
        try{
            if(fecha(puesto.getHoraApertura()) == false){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Verifica la Hora que sea formato: 12:00",""));
                   }else if(fecha(puesto.getHoraCierre()) == false){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Verifica la Hora",""));
                   }else{
        Puesto pedit = new Puesto();
    
        
        pedit.setNIdPuesto(puesto.getNIdPuesto());
        pedit.setHoraApertura(puesto.getHoraApertura());
        pedit.setHoraCierre(puesto.getHoraCierre());
        
        pedit.setNombre(puesto.getNombre());
        pedit.setTipoComida(puesto.getTipoComida());
        pedit.setNomDuenio(puesto.getNomDuenio());
        pedit.setAppDuenio(puesto.getAppDuenio());
        pedit.setApmDuenio(puesto.getApmDuenio());
   
     
        pues.edit(pedit);
                 FacesContext.getCurrentInstance().addMessage(null,
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades, el registro se ha realizado correctamente", ""));
       
                   }
        }catch(Exception ex){
        ex.printStackTrace();
        }
           
    }//fin del metodo editar
    
    
    
    
}//fin de la clase EditaC
