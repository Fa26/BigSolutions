/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Puesto;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que permite la conexion con una base de datos especifica, 
 * asi como realizar distintas operaciones sobre esta. 
 * 
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
            con = DriverManager.getConnection(connectionUrl, "root", "password");
        } catch (ClassNotFoundException | SQLException e) {
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
    * Metodo que resgitra un puesto nuevo en la base de datos
    * @param nombreP - nombre del puesto
    * @param hora_A - hora de apertura
    * @param hora_C - hora de cierre
    * @param tipoComida - tipo de comida 
    * @param nombreD - nombre del duenio
    * @param Apm - apellido materno del duenio
    * @param App - apellido paterno del duenio
    * @param foto - foto del local
    * @throws SQLException 
    * @version 1.0
    */
    
     public void registraPuestos(String nombreP,String hora_A,String hora_C,String 
            tipoComida,String nombreD,String Apm,String App,String foto) throws SQLException{
        try{
           
             stmt = con.createStatement();
             stmt.executeUpdate("INSERT INTO Puesto (hora_apertura,hora_cierre,"
                     + "tipo_comida,nombre,nom_duenio,app_duenio,apm_duenio,foto)"
                     + "VALUES(' "+hora_A+" ',' "+hora_C+" ','"+tipoComida+"',"
                     + "'"+nombreP+"','"+nombreD+"','"+App+"','"+Apm+"','"+foto+"');");
             stmt.close();
  
        }catch(Exception e){}
        
    }//fin del  metodo regsitrarPuestos
    
}
