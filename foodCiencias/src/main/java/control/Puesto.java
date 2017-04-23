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
 * @author Fatima
 */
public class Puesto extends Control{
    private int id;
    private String nombrePuesto,
            duenioPuesto,
            tipoComida,
            horaApertura,
            horaCierre,
            appDuenio,
            apmDuenio,
            foto;
    
    /**
     * Metodo encargado de obtener el id del Puesto.
     * @return int - id del puesto.
     * @version 1.0
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo encargado de establecer el id del Puesto.
     * @version 1.0
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo encargado de obtener el nombre del Puesto.
     * @return String - nombre del puesto.
     * @version 1.0
     */
    public String getNombrePuesto() {
        return nombrePuesto;
    }

    /**
     * Metodo encargado de establecer el nombre del Puesto.
     * @version 1.0
     */
    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    /**
     * Metodo encargado de obtener el nombre del 
     * duenio del Puesto.
     * @return String - nombre del duenio.
     * @version 1.0
     */
    public String getDuenioPuesto() {
        return duenioPuesto;
    }

    /**
     * Metodo encargado de establecer el nombre del duenio del Puesto.
     * @version 1.0
     */
    public void setDuenioPuesto(String duenioPuesto) {
        this.duenioPuesto = duenioPuesto;
    }

    /**
     * Metodo encargado de obtener el topo de comida 
     * que vende el Puesto.
     * @return String - tipo de comida.
     * @version 1.0
     */
    public String getTipoComida() {
        return tipoComida;
    }

    /**
     * Metodo encargado de establecer el tipo de comida del Puesto.
     * @version 1.0
     */
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    /**
     * Metodo encargado de obtener la hora de apertura
     * del Puesto.
     * @return String - hora de apertura.
     * @version 1.0
     */
    public String getHoraApertura() {
        return horaApertura;
    }

    /**
     * Metodo encargado de establecer la hora de apertura del Puesto.
     * @version 1.0
     */
    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Metodo encargado de obtener la hora de cierre
     * del Puesto.
     * @return String - hora de cierre.
     * @version 1.0
     */
    public String getHoraCierre() {
        return horaCierre;
    }

    /**
     * Metodo encargado de establecer la hora de cierre del Puesto.
     * @version 1.0
     */
    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
     
    /**
     * Metodo encargado de establecer el apellido paterno del duenio
     * @param appDuenio 
     * @version 1.0
     */
    public void setAppDuenio(String appDuenio ){
        this.appDuenio=appDuenio;
    }
    
    /**
     * Metodo encargado de obtener el apellido paterno del duenio
     * @return 
     * @verion 1.0
     */
    public String getAppDuenio(){
        return appDuenio;
    }
    
    /**
     * Metodo encargado de establecer el Apellido materno del duenio
     * @param apmDuenio 
     * @version 1.0
     */
    public void setApmDuenio(String apmDuenio){
        this.apmDuenio=apmDuenio;
    }
    /**
     * Metodo encargado de obtener el apellido materno del duenio
     * @return 
     * @version 1.0
     */
    public String getApmDuenio(){
        return apmDuenio;
    }
    /**
     * Metodo encargado de estabelcer la foto del puesto
     * @param foto 
     * @version 1.0
     */
    public void setFoto(String foto){
        this.foto=foto;
    }
    /**
     * Metodo encargado de obetener la foto del duenio
     * @return 
     * @version 1.0
     */
    public String getFoto(){
        return foto;
    }
  
    
    /**
     * Metodo encargado de buscar puestos en la base de datos de 
     * acuerdo a una cadena que recibe como argumento. 
     * @param aBuscar - cadena con la que buscar puestos en la base. 
     * @return ArrayList - puestos encontrados. 
     * @throws Exception en caso de ocurrir alguna anomalia. 
     * @version 1.0
     */
    public ArrayList buscarPuestos(String aBuscar) throws Exception{
        ArrayList puestos = new ArrayList();
        try{
            puestos = conexionBD.obtenerPuestos(aBuscar);
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar los puestos " + ex.getMessage());
        }
        return puestos;
    }
    
      /**
    * Metodo que resgitra un puesto nuevo 
    * @param nombreP - nombre del puesto
    * @param hora_A - hora de apertura
    * @param hora_C - hora de cierre
    * @param tipoComida - tipo de comida 
    * @param nombreD - nombre del duenio
    * @param Apm - apellido materno del duenio
    * @param App - apellido paterno del duenio
    * @param foto - foto del local
    * 
    * @version 1.0
    */
    
    public void  registrarPuestos(String nombreP,String hora_A,String hora_C,String 
            tipoComida,String nombreD,String Apm,String App,String foto ){
                    
         try{
            
              conexionBD.registraPuestos(nombreP,hora_A,hora_C,tipoComida,nombreD,
                                                    Apm,App,foto);
        }catch(Exception ex){
            System.out.println("No se pudieron insertar los puestos " + ex.getMessage());
        }
    }
    
    
}
