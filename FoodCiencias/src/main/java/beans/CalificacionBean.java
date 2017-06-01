/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import control.CalificacionJpaController;
import entidad.Calificacion;
import entidad.CalificacionPK;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import org.primefaces.event.RateEvent;
 
@ManagedBean
@RequestScoped
public class CalificacionBean {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    CalificacionJpaController cCalificacion = new CalificacionJpaController(emf);
    private Calificacion calif;
    private Integer valor;


     
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void addCalificacion() throws Exception{
      
        CalificacionPK cpk = new CalificacionPK();
        cpk.setNIdPuesto(1);
        cpk.setNIdUsuario(1);
        Calificacion c1 = new Calificacion();
        c1.setCalificacionPK(cpk);
        c1.setCalificacion(valor);
        c1.setPuesto(null);
        c1.setUsuario(null);
        cCalificacion.create(c1);
        System.out.println("valor + "+ valor);
    }

    /**
     * @return the calif
     */
    public Calificacion getCalif() {
        return calif;
    }

    /**
     * @param calif the calif to set
     */
    public void setCalif(Calificacion calif) {
        this.calif = calif;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
}
