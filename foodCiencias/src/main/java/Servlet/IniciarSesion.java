/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.*;
import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        int num;
        String corr = request.getParameter("correo");
        String cont = request.getParameter("cont");
        Verificacion ver = new Verificacion();
        boolean val = ver.validarUsuario(corr, cont);
        

        if(val == true){
            Verificacion ver2 = new Verificacion();
            Usuario usr = ver2.regresarUsuario(corr, cont);            
            String usuario = usr.getUsuario();
            String correo = usr.getCorreo();
            String contraseña = usr.getContraseña();
            String nombre = usr.getNombre();
            String app = usr.getApp();
            String apm = usr.getApm();
            String foto = usr.getFoto();
            response.sendRedirect("Inicio.jsp?usuario="+usuario+"&correo="+correo+"&contraseña="+contraseña+"&nombre="+nombre+"&app="+app+"&apm="+apm+"&foto="+foto); 
     
            
        }else{
            //response.sendRedirect("Inicio.jsp?dato1 = " + correo + "&dato2 = "+ contraseña);
            //response.sendRedirect("index.jsp");
            out.println("<pre> Usuario o contraseña incorrecta </pre>");
        }
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
