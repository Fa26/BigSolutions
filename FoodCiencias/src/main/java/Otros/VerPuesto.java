/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import control.CalificacionJpaController;
import control.ComentarioJpaController;
import control.LugarJpaController;
import control.PuestoJpaController;
import entidad.Calificacion;
import entidad.Comentario;
import entidad.Lugar;
import entidad.Puesto;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase controlador de InfoPuesto
 * @author Andres
 */
@ManagedBean
@ViewScoped
public class VerPuesto implements Serializable{
    
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("FoodCienciasPU");
    private final PuestoJpaController jpaPuesto;
    private final LugarJpaController jpaLugar;
    private final ComentarioJpaController jpaComentario;
    private int id;
    private Puesto puesto;
    private Lugar lugar;
    private List<Calificacion> calificacion;
    private List<Comentario> comentario;

    /**
     * Constructor
     */
    public VerPuesto() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
        this.jpaPuesto = new PuestoJpaController(this.emf);
        this.jpaLugar = new LugarJpaController(emf);
        this.jpaComentario = new ComentarioJpaController(this.emf);
    }

    /**
     * Metodo encargado de cambiar el id del puesto actual.
     */
    public void setId(int l){
        this.id = l;
    }

    /**
     * Metodo encargado de devolver el id del puesto actual.
     * @return Long - puesto actual.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Metodo encargado de inicializar los atributos del puesto.
     * @return String - direccionamiento.
     */
    public String obtenerPuesto(){
        if (this.id == 0) {
            return "index";
        }

        this.puesto = jpaPuesto.findPuesto(this.id);
        this.lugar = jpaLugar.findLugar(this.id);
        if (this.puesto == null) {
                return "index";
        }
        this.comentario = jpaComentario.findAllByPuestoID(this.puesto);

        return null;
    }

    /**
     * Metodo encargado de devolver el puesto actual.
     * @return Puesto - puesto actual.
     */
    public Puesto getPuesto() {
        return this.puesto;
    }
    
    /**
     * Metodo encargado de devolver el lugar actual.
     * @return Puesto - puesto actual.
     */
    public Lugar getLugar() {
        return this.lugar;
    }

    /**
     * Metodo encargado de calcular el promedio de calificaciones de un puesto. 
     * @return int - promedio de calificaciones.
     */
    public int getPromedioCalificacion(){
        float promedio = 0;
        if(this.calificacion != null) {
            for(Calificacion c : this.calificacion) {
                promedio = promedio + c.getCalificacion();
            }
            promedio = promedio / this.calificacion.size();
        }
        return Math.round(promedio);
    }
    
    /**
     * Metodo encargado de devolver la lista de comentarios del presente puesto.
     *@return List - lista de objetos comentario. 
     */
    public List<Comentario> getComentario(){
        return this.comentario;
    }

    /**
     * Metodo encargado de devolver la lista de calificaciones de un puesto. 
     *@return List - lista de califiicaciones. 
     */
    public List<Calificacion> getCalificaciones(){
        return this.calificacion;
    }
}

