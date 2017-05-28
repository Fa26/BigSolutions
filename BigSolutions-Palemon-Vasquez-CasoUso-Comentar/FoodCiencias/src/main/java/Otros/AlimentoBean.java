/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import java.io.Serializable;
import static java.sql.Types.INTEGER;
import java.util.Date;
import javafx.scene.text.Text;
import static javax.persistence.DiscriminatorType.INTEGER;
/**
 *
 * @author FaVenegas
 */
public class AlimentoBean implements Serializable{
    
    private Integer nIdAlimento;
    private String nombreAlimento;
   // private Integer nIdPuesto;
    
    
    public AlimentoBean(Integer nIdAlimento, String nombreAlimento){
        this.nIdAlimento=nIdAlimento;
        this.nombreAlimento=nombreAlimento;
       // this.nIdPuesto=nIdPuesto;
    }
    
    public Integer getNid(){
        return this.nIdAlimento;
    }
    
    public String getAlimeno(){
        return this.nombreAlimento;
    }
    
    public void setNid(Integer nid){
        this.nIdAlimento=nid;
    
    }
   /* public void setAlimento(String ali){
        this.nombreAlimento=ali;
    }
        public Integer getNidP(){
        return this.nIdPuesto;
    }*/
    
   
    
    
}//fin de la clase AlimentoBean
