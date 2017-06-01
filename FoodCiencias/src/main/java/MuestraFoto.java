/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.UsuarioBean;
import control.UsuarioJpaController;
import entidad.Usuario;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author leo
 */
@MultipartConfig
@WebServlet(urlPatterns = "MuestraFoto")
public class MuestraFoto extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    Usuario usuario;
    UsuarioBean userB;
    UsuarioJpaController u;
     private FacesContext faceContext; // Obtiene información de la aplicación
    private HttpSession sesion;
    private HttpServletResponse response;
    private HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
  
    
//request es para recibir algo 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           faceContext = FacesContext.getCurrentInstance();
          httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        
        //String  id = request.getParameter("id"); te da el paramero por arte de magia
        //int nId = Integer.parseInt(id);// es para pasarel el id  del usuario. de la sesion acual
        u = new UsuarioJpaController(emf);
        //usuario = u.findUsuario(nId);//busca  el usuario pr el id
        //usuario = u.findUsuario(10);
        usuario = (Usuario) httpServletRequest.getSession().getAttribute("sessionUsuario");
        OutputStream foto = response.getOutputStream();
        foto.write(usuario.getFoto());
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String  id =request.getParameter("id");
        //int id;
        //id = Integer.parseInt(id);
        //usuario = u.findUsuario(22);
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
