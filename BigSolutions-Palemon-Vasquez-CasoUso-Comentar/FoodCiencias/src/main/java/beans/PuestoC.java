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
public class PuestoC {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    PuestoJpaController pues = new PuestoJpaController(emf);

    private Puesto puesto = new Puesto();

    public PuestoC() {
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
           }
           
      
    }//fin add Puesto
}//fin de la clase PuestoC

