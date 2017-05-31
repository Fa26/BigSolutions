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
import entidad.Comentario;
import control.ComentarioJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mint
 */
@ManagedBean
@RequestScoped
public class ComentarioBean {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    ComentarioJpaController cComentario = new ComentarioJpaController(emf);
    private Comentario textoComentario;

    /**
     * Creates a new instance of ComentarioBean
     */
    public ComentarioBean() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es-Mx"));
        textoComentario = new Comentario();//importante para obtener erro
    }

    public String generarComentario() {
        String resultado = "";
        if (textoComentario.getTexto() != null) {
            resultado = "Comenario: " + textoComentario.getTexto();
        }
        return resultado;
    }

    /**
     * /
     *
     **
     * @return the textoComentario
     */
    public Comentario getTextoComentario() {
        return textoComentario;
    }

    /**
     * @param textoComentario the textoComentario to set
     */
    public void setTextoComentario(Comentario textoComentario) {
        this.textoComentario = textoComentario;
    }

    public String addComentario() {

        if (textoComentario.getTexto() != "") {
            System.out.println("Texto: " + textoComentario.getTexto());
            Comentario c = new Comentario();
            c.setTexto(textoComentario.getTexto());
            cComentario.create(c);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Comentario registrado", ""));

            textoComentario = null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Comentario no registrado, ingrese un texto", ""));
        }
        return null;
    }
}
