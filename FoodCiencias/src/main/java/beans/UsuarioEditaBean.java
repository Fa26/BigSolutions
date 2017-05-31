/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
@ManagedBean(name = "editaUsuario")
@RequestScoped  //significa que se aplica  una nueva  solicitud
/**
 *
 * @author leo
 */
public class UsuarioEditaBean {

    private UploadedFile foto;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");

    private UsuarioJpaController usuarioController;
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message;
    private Usuario usuario;

    public UsuarioEditaBean() {

        faceContext = FacesContext.getCurrentInstance();
        emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
        usuarioController = new UsuarioJpaController(emf);
        usuario = usuarioController.findUsuario(10);

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public void editarUsuario() {

        UsuarioBean usr = new UsuarioBean();

        //Usuario u = usr.buscaCorreo(usuario.getCorreo());
        int id = 16;

        try {

            System.out.println(1);
            //if(usuarioController.findUsuario(19) != null){
            System.out.println(2);

            if (foto != null) {
                usuario.setFoto(foto.getContents());
                System.out.println(3);
            }

            System.out.println(4);

            usuarioController.edit(usuario);
            System.out.println(5);

            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo ya esta registrado por otro usuario" + usuario.getCorreo(), null);
            faceContext.addMessage(null, message);

        } catch (Exception e) {
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede  rayos", null);
        }

    }

}
