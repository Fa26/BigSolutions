/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author carloazul21
 */
import Controlador.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Verificacion extends ConexionBD{
    
    public boolean validarUsuario(String correo, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT * FROM Usuario WHERE correo = ? AND contrasenia = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                return true;
            }
            
        }catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println("ERROR " + e);
            }
        }
            
        return false;
    }
    
    public Usuario regresarUsuario(String correo, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT * FROM Usuario WHERE correo = ? AND contrasenia = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            if(rs.next()){
                Usuario usr = new Usuario();
                usr.setUsuario((String)rs.getObject(2));
                usr.setCorreo((String)rs.getObject(3));
                usr.setContraseña((String)rs.getObject(4));
                usr.setNombre((String)rs.getObject(5));
                usr.setApp((String)rs.getObject(6));
                usr.setApm((String)rs.getObject(7));
                usr.setFoto((String)rs.getObject(8));
                return usr;                                
            }
            
        }catch(Exception e){
            System.err.println("Error " + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
                
            }catch(Exception e){
                System.err.println("ERROR "+ e);
            }
        }
        return null;
        
    }
    public static void main(String[] args){
        Verificacion ver = new Verificacion();
        boolean res = ver.validarUsuario("caloazul21@ciencias.unam.mx", "2157");
        Usuario usr = ver.regresarUsuario("carloazul21@ciencias.unam.mx", "2157");
        if(usr != null){
        System.out.println("" + res);
        System.out.println(usr.getUsuario());
        System.out.println(usr.getNombre());
        System.out.println(usr.getApp());
        }
    }
    
}