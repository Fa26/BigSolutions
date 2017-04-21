/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palemon.proyecto.controlador;

import com.palemon.proyecto.modelo.ConexionBD;
import java.sql.Date;
import java.util.ArrayList;

public class Comentario extends Control {
    private  int nIdComentario;
    private Date fecha;
    private String texto;
    private int nIdPuesto;
    private int nIdUsuario;

    /**
     * @return the nIdComentario
     */
    public int getnIdComentario() {
        return nIdComentario;
    }

    /**
     * @param nIdComentario the nIdComentario to set
     */
    public void setnIdComentario(int nIdComentario) {
        this.nIdComentario = nIdComentario;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the nIdPuesto
     */
    public int getnIdPuesto() {
        return nIdPuesto;
    }

    /**
     * @param nIdPuesto the nIdPuesto to set
     */
    public void setnIdPuesto(int nIdPuesto) {
        this.nIdPuesto = nIdPuesto;
    }

    /**
     * @return the nIdUsuario
     */
    public int getnIdUsuario() {
        return nIdUsuario;
    }

    /**
     * @param nIdUsuario the nIdUsuario to set
     */
    public void setnIdUsuario(int nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }
    
        
    /**
     * Metodo encargado de buscar puestos en la base de datos de 
     * acuerdo a una cadena que recibe como argumento. 
     * @param nIdPuestop -id del puesto que queremos ver sus comentarios
     * @return ArrayList -los comentarios del puesto. 
     * @throws Exception en caso de ocurrir alguna anomalia. 
     * @version 1.0
     */
    public static ArrayList buscarComentarios(int nIdPuesto) throws Exception{
        ArrayList comentarios = new ArrayList();
        ConexionBD cn = new ConexionBD();
        try{
            comentarios = cn.obtenerComentarios(nIdPuesto);
            
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar los comentarios " + ex.getMessage());
        }
        return comentarios;
    }
    public int setComentario(String texto) throws Exception{
        int b = 0;
        ConexionBD cn = new ConexionBD();
        try{
            b = cn.setComentario(texto);
        }catch(Exception ex){
            System.out.println("No se pudo registrar el comentario " + ex.getMessage());
        }
        return b;
    }
    
}