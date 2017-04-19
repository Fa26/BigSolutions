/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Puesto;
import java.sql.CallableStatement;
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
            con = DriverManager.getConnection(connectionUrl, "root", "AngelBaseDatos");
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
     * @param nombre
     * @param app
     * @param apm
     * @param contraseña
     * @param correo
     * @return ArrayList - Lista resultado de puestos
     * @throws Exception en caso de que ocurra alguna anomalia
     * @version 1.0
     */
    
     public ArrayList registrarPersona(String nombre, String app, String apm, String correo, String contraseña) throws Exception{
        ArrayList<String> Registro = new ArrayList<>();
        String p = "";
        try{
            /*CallableStatement cs = con.prepareCall("{call RegistraUsuario(?,?,?,?,?,?,?,?)}");
            cs.setInt(0, 2);
            cs.setString(1, nombre);
            cs.setString(2, nombre);
            cs.setString(3, app);
            cs.setString(4, apm);
            cs.setString(5, correo);
            cs.setString(6, contraseña);
            cs.setString(7, "");*/
            
            
            consul = con.prepareStatement("INSERT INTO Usuario ( usuario, nombre, app,apm,correo,contrasenia,foto)VALUES (?,?,?,?,?,?,?)");
            
            consul.setString(2, nombre);
            consul.setString(3, nombre);
            consul.setString(4, app);
            consul.setString(5, apm);
            consul.setString(6, correo);
            consul.setString(7, contraseña);
            consul.setString(8, "");
            
            System.out.println("Usuario Registrada correctamente <br> nombre: " + nombre + " " + app + " " + apm + "<br> Correo: " +correo
                    +"<br> contraseña: " + contraseña );
            
            consul.execute();
            
            
            p = "Usuario Registrada correctamente <br> nombre: " + nombre + " " + app + " " + apm + "<br> Correo: " +correo
                    +"<br> contraseña: " + contraseña ;
            Registro.add(p);
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage() + " registrarPersona");
        }
        return Registro;
    }
    
    
}
