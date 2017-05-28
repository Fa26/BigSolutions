/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

/**
 *
 * @author FaVenegas
 */
public class UsuarioBean {
    
    private Integer nIdUsuario;
    private String usuario;
    private String correo;
    private String contrasenia;
    private String nombre;
    private String app;
    private String apm;
    private byte[] foto;
    
    
    public UsuarioBean(Integer nIdUsuario, String usuario,String correo,String contrasenia,
                        String nombre,String app,String apm,byte[] foto){
        this.nIdUsuario=nIdUsuario;
        this.usuario=usuario;
        this.correo=correo;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
        this.app=app;
        this.apm=apm;
        this.foto=foto;
    
    }
    
    public Integer getNid(){
        return this.nIdUsuario;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getContrsenia(){
        return this.contrasenia;
    }
    public String getNom(){
        return this.nombre;
    }
    public String getApp(){
        return this.app;
    }
    public String getApm(){
        return this.apm;
    }
    public byte[] getFoto(){
        return this.foto;
    }
    
    public void setNid(Integer nid){
        this.nIdUsuario=nid;
    }
    public void setUsua(String usua){
        this.usuario=usua;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setContra(String contra){
        this.contrasenia=contra;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApp(String app){
        this.app=app;
    }
    public void setApm(String apm){
        this.apm=apm;
    }
    public void setFoto(byte[] foto){
        this.foto=foto;
    }
    
    
    
    
}//fin de la clase UsuarioBean
