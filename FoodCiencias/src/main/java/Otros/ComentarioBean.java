/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import java.io.Serializable;
import java.util.Date;
import javafx.scene.text.Text;

/**
 *
 * @author FaVenegas
 */
public class ComentarioBean implements Serializable{
    
    
    private Integer nIdComentario;
    private Date fecha;
    private String texto;
    
    
    public ComentarioBean( Integer nIdComentario,Date fecha,String texto){
        this.nIdComentario=nIdComentario;
        this.fecha=fecha;
        this.texto=texto;
    
    }
    
    public Integer getnId(){
        return this.nIdComentario;
    }
    public Date getFecha(){
        return this.fecha;
    }
    public String getText(){
        return this.texto;
    }
    
    public void setIn(Integer nid){
        this.nIdComentario=nid;
    
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public void setText(String texto){
        this.texto=texto;
    }
    
    
    
    
    
    
      
    
    
    
}// fin de la clase ComentarioBean
