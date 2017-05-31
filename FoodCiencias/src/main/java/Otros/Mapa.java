/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import control.LugarJpaController;
import entidad.Lugar;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Andres
 */

@ManagedBean
@ViewScoped
public class Mapa implements Serializable{

    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("FoodCienciasPU");
    private MapModel mapModel;
    private Marker marker;

    /**
     * Metodo encargado de inicializar el mapa.
     */
    @PostConstruct
    public void init() {
        
        mapModel = new DefaultMapModel();
        
        LugarJpaController jpaLugar = new LugarJpaController(emf);

        /* Se obtienen todos los puestos y se agregan los respectivos marcadores. */
        for (Lugar l : jpaLugar.findLugarEntities()) {
            Double latitud = Double.parseDouble(l.getLatitud());
            Double longitud = Double.parseDouble(l.getLongitud());
            String nombre = l.getNombre();
            mapModel.addOverlay(new Marker(new LatLng(latitud, longitud), nombre, l));
        }
    }

    /**
     * Metodo que regresa el modelo de mapa. 
     * @return MapModel
     */
    public MapModel getMapModel() {
        return mapModel;
    }

    /**
     * Metodo encargado de mostrar info de un puesto al hacer clic cobre el. 
     * @param event evento que desencadena la ejecucion de este metodo.
     */
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    /**
     * Metodo encargado de devolver el marcador actual.
     * @return Marker - marcador actual.
     */
    public Marker getMarker() {
        return marker;
    }
    
}