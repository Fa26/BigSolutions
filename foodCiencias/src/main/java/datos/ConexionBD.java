/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Usuario;
import control.Puesto;
import control.Administrador;
import control.Comentario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private PreparedStatement consul;
    
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
            con = DriverManager.getConnection(connectionUrl, "root", "21574101");
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
     * Metodo encargado de obtener los puestos registrados en la base de datos.
     * @param aBuscar - cadena de texto a buscar en las columnas de la tabla Puesto. 
     * @return ArrayList - Lista resultado de puestos
     * @throws Exception en caso de que ocurra alguna anomalia
     * @version 1.0
     */
    public ArrayList obtenerPuestos(String aBuscar) throws Exception {
        ArrayList puestos = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "SELECT * FROM Puesto\n" +
                    "WHERE nombre LIKE '%" + aBuscar + "%'\n" +
                    "   OR tipo_comida LIKE '%" + aBuscar + "%'\n" +
                    "   OR nom_duenio LIKE '%" + aBuscar + "%'\n" +
                    "   OR app_duenio LIKE '%" + aBuscar + "%'\n" +
                    "   OR apm_duenio LIKE '%" + aBuscar + "%';");
            while (rs.next()) {
                Puesto e = new Puesto();
                e.setId(rs.getInt(1));
                e.setNombrePuesto(rs.getString(5));
                e.setDuenioPuesto(rs.getString(6));
                e.setTipoComida(rs.getString(4));
                e.setHoraApertura(rs.getString(2));
                e.setHoraCierre(rs.getString(3));
                puestos.add(e);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPuestos");
        }
        return puestos;
    }
    
    /**
     * Metodo encargado de registrar usuarios a la base de datos.
     * @param nombre - cadena que representa el nombre. 
     * @param app - cadena que representa el apellido paterno.
     * @param apm - cadena que representa el apellido materno.
     * @param contraseña - cadena que representa la contrasena de usuario
     * @param correo - cadena que representa el correo electronico.
     * @return b - 
     * @throws Exception en caso de que ocurra alguna anomalia.
     * @version 1.0
     */
    public int setUsuario(String nombre, String app, String apm, String correo, String contraseña ) throws Exception {
        int b = 0;
        try {
            stmt = con.createStatement();
            System.out.println("1");
            stmt.executeUpdate("INSERT INTO Usuario(usuario,correo, contrasenia, nombre, app, apm)  "
                    + "VALUES ('" + nombre + "','" 
                    + correo + "','" 
                    + contraseña + "','" 
                    + nombre + "','" 
                    + app + "', '" 
                    + apm + "')");
            System.out.println("2");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " setPersona");
        }
        return b;
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
     
     public boolean validarUsuario(String correo, String contraseña){
        try{
            stmt = con.createStatement();
            String consulta = "SELECT * FROM Usuario WHERE correo LIKE '%" + correo + "%'\n" +
                    "   AND contrasenia LIKE '%" + contraseña + "%';";
            rs = stmt.executeQuery(consulta); 
            if(rs.next()){
                return true;
            }
            stmt.close();
            rs.close();
            
        }catch(Exception e){
            System.err.println("Error" + e);
        }
            
        return false;
    }
     
     public Usuario regresarUsuario(String correo, String contraseña){
        try{
            stmt = con.createStatement();
            String consulta = "SELECT * FROM Usuario WHERE correo  LIKE '%" + correo + "%'\n" +
                    "   AND contrasenia LIKE '%" + contraseña + "%';";
            rs = stmt.executeQuery(consulta);
            if(rs.next()){
                Usuario usr = new Usuario();
                usr.setUsuario((String)rs.getObject(2));
                usr.setCorreo((String)rs.getObject(3));
                usr.setContrasenia((String)rs.getObject(4));
                usr.setNombre((String)rs.getObject(5));
                usr.setApp((String)rs.getObject(6));
                usr.setApm((String)rs.getObject(7));
                return usr;                                
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return null;
        
    }
     
     public boolean validarAdministrador(String correo, String contraseña){
        try{
            stmt = con.createStatement();
            String consulta = "SELECT * FROM Administrador WHERE correo LIKE '%" + correo + "%'\n" +
                    "   AND contrasenia LIKE '%" + contraseña + "%';";
            rs = stmt.executeQuery(consulta); 
            if(rs.next()){
                return true;
            }
            stmt.close();
            rs.close();
            
        }catch(Exception e){
            System.err.println("Error" + e);
        }
            
        return false;
    }
     
    public Administrador regresarAdministrador(String correo, String contraseña){
        try{
            stmt = con.createStatement();
            String consulta = "SELECT * FROM Administrador WHERE correo LIKE '%" + correo + "%'\n" +
                    "   AND contrasenia LIKE '%" + contraseña + "%';";
            rs = stmt.executeQuery(consulta);
            if(rs.next()){
                Administrador adm = new Administrador();
                adm.setUsuario((String)rs.getObject(2));
                adm.setCorreo((String)rs.getObject(3));
                adm.setContrasenia((String)rs.getObject(4));
                return adm;                                
            }
            
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return null;
        
    }
    
     /**
     * Metodo encargado de obtener los puestos registrados en la base de datos.
     * @return ArrayList - Lista resultado de comentarios
     * @throws Exception en caso de que ocurra alguna anomalia
     * @version 1.0
     */
    public  ArrayList obtenerComentarios(String nIdPuesto) throws Exception {
        ArrayList comentarios = new ArrayList();

        try {
            String query1 = "SELECT * FROM Comentario;\n";
                    //+ "WHERE nIdPuesto LIKE '%NULL%';";
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
    
        
    public int setComentario(String fecha,String texto) throws SQLException {
        int b = 0;

        try {
            String query = "INSERT INTO Comentario(fecha, texto)"
                    + "VALUES('"+fecha+"','"+texto+"');";  
            stmt = con.createStatement();
            stmt.execute(query);   
            b = 1;
            stmt.close();
            
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getComentarios");
        }
        return b;
        
    }
}
