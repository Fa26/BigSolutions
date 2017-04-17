/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static modelo.ConexionBD_.horaCierre;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author FaVenegas
 */
@WebServlet(name = "PuestoC", urlPatterns = {"/PuestoC"})
public class Puesto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
     DateFormat sdf = new SimpleDateFormat("HH:mm");
    
    
     
     String nombreP=request.getParameter("nombre");
     String hora_A=request.getParameter("hora_apertura");
     String hora_C=request.getParameter("hora_cierre");
     String tipoComida=request.getParameter("tipo_comida");
     String nombreD=request.getParameter("nom_duenio");
     String Apm=request.getParameter("app_duenio");
     String App=request.getParameter("apm_duenio");
     String foto=request.getParameter("foto");
     
     try{
     Date fecha = sdf.parse(hora_A);
     Date fechaC =sdf.parse(hora_C);
     
     
     modelo.ConexionBD puesto = new modelo.ConexionBD();
     puesto.setNIdPuesto(0);
     puesto.setHoraApertura(fecha);
     puesto.setHoraCierre(fechaC);
     puesto.setTipoComida(tipoComida);
     puesto.setNombre(nombreP);
     puesto.setNomDuenio(nombreD);
     puesto.setAppDuenio(App);
     puesto.setApmDuenio(Apm);
     puesto.setFoto(foto);
   
     
      
     EntityManager em;
     EntityManagerFactory emf;
     emf=Persistence.createEntityManagerFactory("AdmiPuestosPU");
     em=emf.createEntityManager();
     em.getTransaction().begin();
     em.persist(puesto);
     em.flush();
     em.getTransaction().commit();
     response.sendRedirect("index.jsp");
     }catch(ParseException e){};
      
      
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

}
