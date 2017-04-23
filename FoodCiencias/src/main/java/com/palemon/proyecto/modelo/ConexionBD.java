/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palemon.proyecto.modelo;
//import com.mysql.jdbc.*;
import com.palemon.proyecto.controlador.Comentario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *Clase que conecta con la base de datos.
 * @author mint
 */
public class ConexionBD {

        //Creamos nuestros objetos para la comunicacion y ejecucion de codigo SQL
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    //Constructor    
    public ConexionBD() {
        stmt = null;
        con = null;
        rs = null;
    }

    /*
     * Metodo que nos permite abrir la conexion con una base de datos 
     * especifica para el presente proyecto.
     * @version 1.0
     */
    public void conectar()throws Exception {
       
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/FoodCiencias";  
            con = DriverManager.getConnection(connectionUrl, "root", "root");
            
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " conectar :(");
        }
    }

    /*
     * Metodo que nos permite cerrar la conexion con una base de datos. 
     * Este metodo debe ser invocado en la capa de Control.
     * @version 1.0
     */
    public void desconectar()
            throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " desconectar =(");
        }
    }
    
    /**
     * Metodo encargado de obtener los puestos registrados en la base de datos.
     * @return ArrayList - Lista resultado de puestos
     * @throws Exception en caso de que ocurra alguna anomalia
     * @version 1.0
     */
    public  ArrayList obtenerComentarios(String nIdPuesto) throws Exception {
        ArrayList comentarios = new ArrayList();

        try {
            String query1 = "SELECT * FROM Comentario\n"
                    + "WHERE nIdPuesto LIKE '%1%';";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query1);
            while (rs.next()) {
                Comentario c = new Comentario();
                c.setnIdComentario(rs.getInt(1));
                c.setFecha(rs.getDate(2));
                c.setTexto(rs.getString(3));
                c.setnIdPuesto(rs.getInt(4));
                c.setnIdUsuario(rs.getInt(5));
                comentarios.add(c);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getComentarios");
        }
        return comentarios;
    }
    
        
    public int setComentario(String texto) throws SQLException {
        int b = 0;

        try {
            String query = "INSERT INTO Comentario(nIdComentario,fecha, texto, nIdPuesto, nIdUsuario)"
                    + "VALUES(1,'2010-01-01',"+"'"+texto+"'"+",1,1);";  
            stmt = con.createStatement();
            stmt.execute(query);   
            b = 1;
            stmt.close();
            
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getComentarios");
        }
        System.err.println("b3 : " + b);
        return b;
        
    }

}
