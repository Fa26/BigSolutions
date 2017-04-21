/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import junit.framework.TestCase;

/**
 *
 * @author FaVenegas
 * Test de la clase puestos
 */
public class PuestoTest extends TestCase {
    
    public PuestoTest(String testName) {
        super(testName);
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
