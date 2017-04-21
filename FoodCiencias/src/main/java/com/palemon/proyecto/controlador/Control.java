/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palemon.proyecto.controlador;
import com.palemon.proyecto.modelo.ConexionBD;
/**
 *
 * @author mint
 */
public class Control {
      // Se crea un objeto de tipo ConexionBD para abrir la comunicacion con 
    // la base de datos
    ConexionBD conexionBD = new ConexionBD();

    /*
     * Metodo que permite realizar la conexion a una base de datos especifica.
     * @author     Andres
     * @version    1.0         
     */
    public void conecta() throws Exception{
        try {
            conexionBD.conectar();
        } catch (Exception e) {
            System.out.println("Conexión fallida" + e.getMessage());
        }
    }

    /*
     * Metodo que permite realizar la desconexion de una base de datos.
     * @author 
     */
    public void desconecta() throws Exception{
        try {
            conexionBD.desconectar();
        } catch (Exception e) {
            System.out.println("Desconexión fallida" + e.getMessage());
        }
    }      
}
