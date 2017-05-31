/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import control.LugarJpaController;
import entidad.Lugar;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author FaVenegas
 */
@ManagedBean

public class MapaC implements Serializable{
    
	private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("FoodCienciasPU");
     private MapModel emptyModel;

    private Marker marker;

   // private LugarJpaController lugarCtrl;

    private String nombre;

    private double lat;

    private double lng;
    
    
    public MapaC(){
         FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
    
    }
   @PostConstruct
    public void init() {
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
        emptyModel = new DefaultMapModel();
      

/*
        List<Lugar> lugares = lugarCtrl.findLugarEntities();
        for (Lugar lugar : lugares) {
            Double latitud = Double.parseDouble(lugar.getLatitud());
            Double longitud = Double.parseDouble(lugar.getLongitud());
            String nombre = lugar.getNombre();
            System.out.println(latitud + ", " + longitud + ", " + nombre);
            advancedModel.addOverlay(new Marker(new LatLng(latitud, longitud), nombre));
        }*/
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }
    
      public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        System.out.println(marker.getTitle());
    }

    public Marker getMarker() {
        return marker;
    }

    public String getNombre() {
        return nombre;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }
    
    
    public void setLng(double lng) {
        this.lng = lng;
    }

    public void addMarker() {
        
        Marker marker = new Marker(new LatLng(lat, lng), nombre);
        emptyModel.addOverlay(marker);
        LugarJpaController lc = new LugarJpaController(emf);
        Lugar l = new Lugar();
        l.setLatitud(Double.toString(lat));
        l.setLongitud(Double.toString(lng));
        l.setNombre(nombre);
        try{
        lc.create(l);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
        }catch(Exception w){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
             "Fallo de registro: No se puede registrar el mapa", "")); 
        }
      
      
        }
    
    
    
    
    
    
    
}//fin de la clase Mapa
