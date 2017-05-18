/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;



import control.ComentarioJpaController;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import entidad.Usuario;
import control.ComentarioJpaController;
import control.UsuarioJpaController;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author leo
 */
@ManagedBean(name = "EditarUsuario")
@RequestScoped  //significa que se aplica  una nueva  solicitud
/**
 *
 * @author leo
 */
public class UsuarioEditaBean {
    
    
    private UploadedFile  foto;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    ComentarioJpaController user = new ComentarioJpaController(emf);
    private Usuario usuario;
    private UsuarioJpaController usuarioController;    
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message;

    public UsuarioEditaBean() {
        usuario = new Usuario();
        faceContext = FacesContext.getCurrentInstance();
        emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
        usuarioController = new UsuarioJpaController(emf);
        
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    
    
    public void editarUsuario(){
        
    
    }
    
    
    
    
    
    
}
