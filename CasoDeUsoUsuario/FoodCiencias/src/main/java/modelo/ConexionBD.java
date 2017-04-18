/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase que permite la conexion con una base de datos especifica, 
 * asi como realizar distintas operaciones sobre esta. 
 * @author Andres
 */
public class ConexionBD {
    //Se crean los objetos para la comunicacion y ejecucion de codigo SQL
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    /**
     * Constructor inicializando los parametros en null.
     */ 
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
    public void conectar()
            throws Exception {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/FoodCiencias";  
            con = DriverManager.getConnection(connectionUrl, "root", "AngelBaseDatos");
        } catch (ClassNotFoundException  e) {
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
  
    
    public static void main(String [] args) throws Exception{
      ConexionBD con =  new ConexionBD();
      con.conectar();
    }
    
}
