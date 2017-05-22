/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Otros.PuestoBean;
import Otros.UsuarioBean;
import control.PuestoJpaController;
import control.UsuarioJpaController;
import entidad.Usuario;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author FaVenegas
 */
@ManagedBean
@ViewScoped
public class EliminaUC implements Serializable{
    
    
     EntityManagerFactory emf = 
             Persistence.createEntityManagerFactory("FoodCienciasPU");
   
    private List<Usuario> usuario;
    private List<UsuarioBean> upb;
    
  
    public EliminaUC(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
    }
    
     @PostConstruct
    public void init(){
        usuario = new LinkedList();
        upb = new LinkedList();
        
        UsuarioJpaController user = new UsuarioJpaController(emf);
        usuario=user.findUsuarioEntities();
        
        for(int i=0; i<usuario.size();i++){
            UsuarioBean ub = new UsuarioBean(usuario.get(i).getNIdUsuario(),
                usuario.get(i).getUsuario(),
                usuario.get(i).getCorreo(),
                usuario.get(i).getContrasenia(),
                usuario.get(i).getNombre(),
                usuario.get(i).getApp(),
                usuario.get(i).getApm(),
                usuario.get(i).getFoto());
            
            upb.add(ub);
        }
    }//fin del metodo init
    
    public void setUsu(List usuario){
        this.usuario=usuario;
    }
    public List getUsu(){
        return this.usuario;
    }
    
    public int total(){
        return this.upb.size();
    }
  
    
    
}//fin de la clase EliminaUC
