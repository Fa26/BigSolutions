/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import java.io.Serializable;

/**
 *
 * @author FaVenegas
 */
public class PuestoBean implements Serializable{
    
    private Integer nIdPuesto;
    private String hora_Apertura;
    private String hora_Cierre;
    private String tipo_comida;
    private String nombre;
    private String nom_duenio;
    private String app_duenio;
    private String apm_duenio;
    
    
   
    public PuestoBean(Integer nIdPuesto,String hora_Apertura,String hora_Cierre,String tipo_comida
    ,String nombre,String nom_duenio,String app_duenio,String apm_duenio){
        this.nIdPuesto=nIdPuesto;
        this.hora_Apertura=hora_Apertura;
        this.hora_Cierre=hora_Cierre;
        this.tipo_comida=tipo_comida;
        this.nombre=nombre;
        this.nom_duenio=nom_duenio;
        this.app_duenio=app_duenio;
        this.apm_duenio=apm_duenio;
    }
    
    public Integer getId(){
        return this.nIdPuesto;
    }
    public String getHA(){
        return this.hora_Apertura;
    }
    public String getHO(){
        return this.hora_Cierre;
    }
    public String getComi(){
        return this.tipo_comida;
    }
    public String getNom(){
        return this.nombre;
    }
    public String getNomD(){
        return this.nom_duenio;
    }
    public String getApm(){
        return this.apm_duenio;
    }
    public String getApp(){
        return this.app_duenio;
    }
    
    public void setID(Integer id){
        this.nIdPuesto=id;
    }
    public void setHa(String ha){
        this.hora_Apertura=ha;
    }
    public void setHc(String hc){
        this.hora_Cierre=hc;
    }
    public void setComida(String tComida){
        this.tipo_comida=tComida;
    }
    public void setNom(String no){
        this.nombre=no;
    }
    public void setNomD(String d){
        this.nom_duenio=d;
    }
    public void setAp(String ap){
        this.app_duenio=ap;
    }
    public void setAm(String am){
        this.apm_duenio=am;
    }
    
    
    
    
    
}//fin de la clase PuestoBean
