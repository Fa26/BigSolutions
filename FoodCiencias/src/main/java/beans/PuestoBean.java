/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import control.ComentarioJpaController;
import entidad.Puesto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
    ComentarioJpaController cPuesto = new ComentarioJpaController(emf);
    private Puesto datoPuesto;
   // private List<Puesto> listPuesto;
    
    /**
     * Creates a new instance of PuestoBean
     */
    public PuestoBean() {
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
    
}
