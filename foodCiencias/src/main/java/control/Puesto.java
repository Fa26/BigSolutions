/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 * Clase para trabajar con puestos. 
 * @author Andres
 */
public class Puesto extends Control{
    private int id;
    private String nombrePuesto,
            duenioPuesto,
            tipoComida,
            horaApertura,
            horaCierre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDuenioPuesto() {
        return duenioPuesto;
    }

    public void setDuenioPuesto(String duenioPuesto) {
        this.duenioPuesto = duenioPuesto;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
    public ArrayList buscarPuestos(String aBuscar) throws Exception{
        ArrayList puestos = new ArrayList();
        try{
            puestos = conexionBD.obtenerPuestos(aBuscar);
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar los puestos " + ex.getMessage());
        }
        return puestos;
    }
    
}
