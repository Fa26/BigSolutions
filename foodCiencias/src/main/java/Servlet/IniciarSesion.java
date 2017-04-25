/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import control.*;
import datos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carloazul21
 */
public class IniciarSesion extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        int num;
        String corr = request.getParameter("correo");
        String cont = request.getParameter("cont");
        ConexionBD ver = new ConexionBD();
        ConexionBD ver1 = new ConexionBD();
        ConexionBD ver2 = new ConexionBD();
        ConexionBD ver3 = new ConexionBD();
        ver.conectar();
        ver1.conectar();
        ver2.conectar();
        ver3.conectar();
        boolean val;
            val = ver.validarUsuario(corr, cont);
           boolean val2 = ver1.validarAdministrador(corr, cont);
        if(val2 == true){
            Administrador adm = ver2.regresarAdministrador(corr, cont);
            String usuario = adm.getUsuario();
            String correo = adm.getCorreo();
            String contraseña = adm.getContrasenia();

            response.sendRedirect("AdministradorV/AdministradorIH.html");
            
        }else if(val == true){
            Usuario usr = ver3.regresarUsuario(corr, cont);            
            String usuario = usr.getUsuario();
            String correo = usr.getCorreo();
            String contraseña = usr.getContrasenia();
            String nombre = usr.getNombre();
            String app = usr.getApp();
            String apm = usr.getApm();
            response.sendRedirect("Inicio.jsp?usuario="+usuario+"&correo="+correo+"&contraseña="+contraseña+"&nombre="+nombre+"&app="+app+"&apm="+apm); 
     
            
        }else{
            //response.sendRedirect("Inicio.jsp?dato1 = " + correo + "&dato2 = "+ contraseña);
            //response.sendRedirect("index.jsp");
            response.sendRedirect("EntrarE.jsp");
        }
        ver.desconectar();
        ver1.desconectar();
        ver2.desconectar();
        ver3.desconectar();
        }finally{
            out.close();
        }
        
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
