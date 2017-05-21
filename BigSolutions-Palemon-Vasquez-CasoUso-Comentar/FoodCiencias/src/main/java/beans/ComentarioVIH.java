/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Otros.ComentarioBean;
import Otros.PuestoBean;
import control.ComentarioJpaController;
import control.PuestoJpaController;
import entidad.Comentario;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
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
@ViewScoped
public class ComentarioVIH implements Serializable {
    
       EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
       
       
       private List<Comentario> comentario;
       private List<ComentarioBean> pb;
       
       
       public ComentarioVIH(){
            FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
       
       }
       
       
         @PostConstruct
    public void init(){
        comentario = new LinkedList();
        pb=new LinkedList();
        ComentarioJpaController ve = new ComentarioJpaController(emf);
        comentario=ve.findComentarioEntities();
        
        for(int i=0; i<comentario.size();i++){
            ComentarioBean pbean = new ComentarioBean(comentario.get(i).getNIdComentario(),
                    comentario.get(i).getFecha(),
                    comentario.get(i).getTexto());
           
            
          pb.add(pbean);
        }
    }
    
     public List getComentarios(){
       return this.comentario;
   }
   public void setPuestos(List comentario){
       this.comentario=comentario;
   }
   
   public int total(){
       return pb.size();
   }
    
    
    
    
}//fin  de la clase ComentarioVIH
