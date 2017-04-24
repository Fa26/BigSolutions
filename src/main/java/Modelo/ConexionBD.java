/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
/**
 *
 * @author carloazul21
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class ConexionBD {
 
private String USERNAME = "root";
private String PASSWORD = "21574101";
private String HOST = "localhost"; 
private String PORT = "3306";
private String DATABASE = "creaEsquema";
private String CLASSNAME = "com.mysql.jdbc.Driver";
private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
private Connection con;


public ConexionBD(){
    try{
        Class.forName(CLASSNAME);
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
    }catch(ClassNotFoundException e){
        System.err.println("ERROR " + e);
    }catch(SQLException e){
        System.err.println("ERROR " + e);
    }
}

public Connection getConexion(){
    return con;
}

}
