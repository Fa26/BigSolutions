/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import control.PuestoJpaController;
import entidad.Puesto;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mint
 */
@ManagedBean
@RequestScoped
public class PuestoBean {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    PuestoJpaController cPuesto = new PuestoJpaController(emf);
    private Puesto datoPuesto;
    private List<Puesto> listPuesto;
    
    
    @PostConstruct
    public void init() {
        listPuesto = cPuesto.findPuestoEntities();
    }
    /**
     * Creates a new instance of PuestoBean
     */
    public PuestoBean() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
        datoPuesto = new Puesto();//importante para obtener erro
    }

    /**
     * @return the datoPuesto
     */
    public Puesto getDatoPuesto() {
        return datoPuesto;
    }

    /**
     * @param datoPuesto the datoPuesto to set
     */
    public void setDatoPuesto(Puesto datoPuesto) {
        this.datoPuesto = datoPuesto;
    }

    /**
     * @return the listPuesto
     */
    public List<Puesto> getListPuesto() {
        return listPuesto;
    }

    /**
     * @param listPuesto the listPuesto to set
     */
    public void setListPuesto(List<Puesto> listPuesto) {
        this.listPuesto = listPuesto;
    }
    
}
