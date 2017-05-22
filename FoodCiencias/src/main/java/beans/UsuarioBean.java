/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import entidad.Usuario;
import control.ComentarioJpaController;
import control.UsuarioJpaController;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.validator.ValidatorException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author leo
 */
@ManagedBean(name = "user")
@RequestScoped  //significa que se aplica  una nueva  solicitud
public class UsuarioBean implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    ComentarioJpaController user = new ComentarioJpaController(emf);
    private Usuario usuario;
    private UsuarioJpaController usuarioController;
    private UploadedFile foto;

    //private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message;

    //Constructor
    public UsuarioBean() {
        usuario = new Usuario();
        faceContext = FacesContext.getCurrentInstance();
        emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
        usuarioController = new UsuarioJpaController(emf);
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

    public Usuario buscaCorreo(String correo) {

        Usuario usr;
        EntityManager em = emf.createEntityManager();
        String consulta = "SELECT u FROM Usuario u WHERE u.correo = :correo ";
        Query query = em.createQuery(consulta);
        query.setParameter("correo", correo);
        List list = query.getResultList();
        if (list.size() > 0) {
            usr = (Usuario) list.get(0);
            return usr;
        } else {
            return null;
        }

    }

    public String registrar() {
        UsuarioBean usr = new UsuarioBean();
        Usuario u = usr.buscaCorreo(usuario.getCorreo());

        try {

            if (usuario.getContrasenia().length() >= 6) {
                if (u == null) {
                    usuario.setUsuario(usuario.getNombre());

                    if (foto != null) {
                        usuario.setFoto(foto.getContents());
                    }

                    usuarioController.create(usuario);
                    validacionCorreo();
                    return "PaginaPrincipal";
                } else {

                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo ya esta registrado por otro usuario" + usuario.getUsuario(), null);
                    faceContext.addMessage(null, message);
                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña es muy  corta", null);
                faceContext.addMessage(null, message);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede  rayos", null);
        }
        return "registro";
    }

    private FacesMessage crearMensajeDeError(String mensaje) {
        return new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null);
    }

    public void validacionCorreo() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");//pide auntentificacion usuario contraseña
        props.put("mail.smtp.starttls.enable", "true");//Encriptacion para la comunicacion.
        props.put("mail.smtp.host", "smtp.mail.com"); //el servidor  donde manda los correo // para mandarlo com prueb an fake es localhost
        props.put("mail.smtp.port", "587");//puerto donde se conecta // cualquier puerto  se tiene que poner en fake

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("FoodCiencias@mail.com", "bigsolution");//la primera cadena es usuario  y la segunda contraseña
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("FoodCiencias@mail.com"));//remitente el que lo manda
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(usuario.getCorreo()));//destinatrio de el correo
            message.setSubject("Testing Subject");//Asunto 
            message.setText("Verificacion del correo,"
                    + "\n\n No spam to my email"
                    + "\n\n Regrese a la pagina de inicio!"
                    + ""); // texto del correo 
            message.setContent("<a href = \" http://localhost:8080/faces/PaginaPrincipal.xhtml\">texto</a>",
                    "text/html; charseft=utf-8");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
