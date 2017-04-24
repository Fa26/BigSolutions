/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Random;
import static junit.framework.Assert.assertEquals;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

/**
 * Clase de prueba para la clase "Puesto".
 * @author Andres
 */
public class PuestoTest extends DatabaseTestCase{
    
    /**
     * Metodo que prueba el metodo "getId" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetId() throws Exception {
        Random random = new Random();

        int testInt = random.nextInt();

        Puesto testPuesto = new Puesto();
        testPuesto.setId(testInt);

        int id = testPuesto.getId();

        assertEquals(id, testInt);
    }
    
    /**
     * Metodo que prueba el metodo "getNombrePuesto" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetNombrePuesto() throws Exception {
        String testString = "Puesto1";

        Puesto testPuesto = new Puesto();
        testPuesto.setNombrePuesto(testString);

        String nombre = testPuesto.getNombrePuesto();

        assertEquals(nombre, testString);
    }
    
    /**
     * Metodo que prueba el metodo "getDuenioPuesto" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetDuenioPuesto() throws Exception {
        String testString = "Duenio1";

        Puesto testPuesto = new Puesto();
        testPuesto.setDuenioPuesto(testString);

        String duenio = testPuesto.getDuenioPuesto();

        assertEquals(duenio, testString);
    }
    
    /**
     * Metodo que prueba el metodo "getTipoComida" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetTipoComida() throws Exception {
        String testString = "Japonesa";

        Puesto testPuesto = new Puesto();
        testPuesto.setTipoComida(testString);

        String tipoComida = testPuesto.getTipoComida();

        assertEquals(tipoComida, testString);
    }
    
    /**
     * Metodo que prueba el metodo "getHoraApertura" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetHoraApertura() throws Exception {
        String testString = "08:00:00";

        Puesto testPuesto = new Puesto();
        testPuesto.setHoraApertura(testString);

        String horaApertura = testPuesto.getHoraApertura();

        assertEquals(horaApertura, testString);
    }
    
    /**
     * Metodo que prueba el metodo "getHoraCierre" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testGetHoraCierre() throws Exception {
        String testString = "20:00:00";

        Puesto testPuesto = new Puesto();
        testPuesto.setHoraCierre(testString);

        String horaCierre = testPuesto.getHoraCierre();

        assertEquals(horaCierre, testString);
    }
    
    /**
     * Metodo que encapsula una conexion JDBC usual.
     * @return IDatabaseConnection - representa una conexion a una base 
     * de datos especifica.
     * @throws Exception si ocurre alguna anomalia.
     */
    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/FoodCienciasTest";  

        Connection jdbcConnection = DriverManager.getConnection(
                connectionUrl, "root", "password");
        
        return new DatabaseConnection(jdbcConnection);
    }
    
    /**
     * Metodo que regresa el dataset de prueba. 
     * @return IDataSet - representa una coleccion de tablas. 
     * @throws Exception si ocurre alguna anomalia.
     */
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("C:\\Users\\Andres\\Documents\\UNAM\\Ciencias de la Computación\\6to semestre\\Ingenieria de Software\\ProyectoJunto\\foodCiencias\\src\\test\\java\\control\\dataset.xml"));
    }
    
    /**
     * Metodo que prueba el metodo "buscarPuestos" para la clase
     * "Puesto".
     * @throws Exception si ocurre alguna anomalia.
     */
    public void testObtenerPuestos() throws Exception{
        Puesto p = new Puesto();
        p.conecta();
        ArrayList puestos = p.buscarPuestos("Polaca");
        p.desconecta();
        
        assertNotNull("puestos no deberia ser null", puestos);
        assertEquals("deberia ser Puesto4", 
                "Puesto4", 
                ((Puesto)puestos.get(0)).getNombrePuesto());
        assertEquals("deberia ser Duenio1", 
                "Duenio1", 
                ((Puesto)puestos.get(0)).getDuenioPuesto());
    }
   
     /**
     * Test of setId method, of class Puesto.
     */
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Puesto instance = new Puesto();
        instance.setId(id);
     
    }


    /**
     * Test of setNombrePuesto method, of class Puesto.
     */
    public void testSetNombrePuesto() {
        System.out.println("setNombrePuesto");
        String nombrePuesto = "Donas";
        if(nombrePuesto == null){
             fail("The test case is a prototype.");
        }
        Puesto instance = new Puesto();
        instance.setNombrePuesto(nombrePuesto);
       
    }

   

    /**
     * Test of setDuenioPuesto method, of class Puesto.
     */
    public void testSetDuenioPuesto() {
        System.out.println("setDuenioPuesto");
        String duenioPuesto = "Ramon";
        Puesto instance = new Puesto();
        instance.setDuenioPuesto(duenioPuesto);
      
    }

   

    /**
     * Test of setTipoComida method, of class Puesto.
     */
    public void testSetTipoComida() {
        System.out.println("setTipoComida");
        String tipoComida = "Caribeña";
        if(tipoComida == null ){
             fail("The test case is a prototype.");
        }
        Puesto instance = new Puesto();
        instance.setTipoComida(tipoComida);
      
    }

    

    /**
     * Test of setHoraApertura method, of class Puesto.
     */
    public void testSetHoraApertura() {
        System.out.println("setHoraApertura");
        String horaApertura = "00:00:00";
        Puesto instance = new Puesto();
        instance.setHoraApertura(horaApertura);
       
    }

    /**
     * Test of setHoraCierre method, of class Puesto.
     */
    public void testSetHoraCierre() {
        System.out.println("setHoraCierre");
        String horaCierre = "00:00:00";
        Puesto instance = new Puesto();
        instance.setHoraCierre(horaCierre);
    }

    /**
     * Test of setAppDuenio method, of class Puesto.
     */
    public void testSetAppDuenio() {
        System.out.println("setAppDuenio");
        String appDuenio = "Ramirez";
        Puesto instance = new Puesto();
        instance.setAppDuenio(appDuenio);
    
    }

  

    /**
     * Test of setApmDuenio method, of class Puesto.
     */
    public void testSetApmDuenio() {
        System.out.println("setApmDuenio");
        String apmDuenio = "Robles";
        Puesto instance = new Puesto();
        instance.setApmDuenio(apmDuenio);
      
    }

   

    /**
     * Test of setFoto method, of class Puesto.
     */
    public void testSetFoto() {
        System.out.println("setFoto");
        String foto = "puesto.jpg";
        Puesto instance = new Puesto();
        instance.setFoto(foto);
       
    }
    /**
     * Test of registrarPuestos method, of class Puesto.
     */
    public void testRegistrarPuestos() {
        System.out.println("registrarPuestos");
        String nombreP = "ostiones";
        String hora_A = "00:00:00";
        String hora_C = "00:00:00";
        String tipoComida = "ostiones";
        String nombreD = "Rafael";
        String Apm = "Robles";
        String App = "Montero";
        String foto = "foto.jpg";
        Puesto instance = new Puesto();
        instance.registrarPuestos(nombreP, hora_A, hora_C, tipoComida, nombreD, Apm, App, foto);
       
    }
}
