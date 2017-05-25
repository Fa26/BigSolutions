/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import dao.AdministradorDao;
import dao.UsuarioDao;
import entidad.Administrador;
import entidad.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author carloazul21
 */

@ManagedBean (name = "login")// LEER LA DOCUMENTACIÖN DE ESTA ANOTACIÓN: Permite dar de alta al bean en la aplicación
@RequestScoped // Sólo está disponible a partir de peticiones al bean
public class loginControlador implements Serializable{

    private String usuario;
    private String correo;
    private String contrasenia;
    private String nombre;
    private String app;
    private String apm;
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
   private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message;
    private HttpSession sesion;
    
    
    

    /**
     * Constructor para inicializar los valores de faceContext y
     * httpServletRequest.
     */
    public loginControlador(){
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getApm() {
            return apm;
        }

        public void setApm(String apm) {
            this.apm = apm;
        }

        public FacesMessage getMessage() {
            return message;
        }

        public void setMessage(FacesMessage message) {
            this.message = message;
        }

     
    
    /**
     * Método encargado de validar el inicio de sesión.
     *
     * @return El nombre de la vista que va a responder.
     */
    public String login() {
        UsuarioDao usr = new UsuarioDao();
        Usuario u = usr.buscaUsuario(correo, contrasenia);
        AdministradorDao adm = new AdministradorDao();
        Administrador a = adm.buscaUsuario(correo, contrasenia);
        if(correo.equals("") || contrasenia.equals("")){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto" + correo + "" + contrasenia, null);
        faceContext.addMessage(null, message);
           return "Entrar"; 
            
        }
        
        if (a != null) {
            usuario = a.getUsuario();
            correo = a.getCorreo();
            contrasenia = a.getContrasenia();            
            sesion = httpServletRequest.getSession();
            sesion.setAttribute("sessionUsuario", a);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, message);
            return "Inicio";
        }else if(u != null){
            usuario = u.getUsuario();
            correo = u.getCorreo();
            contrasenia = u.getContrasenia();
            nombre = u.getNombre();
            app = u.getApp();
            apm = u.getApm();
            sesion = httpServletRequest.getSession();
            sesion.setAttribute("sessionUsuario", u);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, message);
            return "Inicio";
        }
        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto" + correo + "" + contrasenia, null);
        faceContext.addMessage(null, message);
        return "Entrar";
}

    public static void main(String[] args){
        loginControlador lc = new loginControlador();
        lc.setCorreo("pedro1@ciencias.unam.mx");
        lc.setContrasenia("qwe");
        System.out.println(lc.login());
        
        
    }
    
}

