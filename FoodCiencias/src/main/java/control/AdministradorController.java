/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidad.Administrador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author carloazul21
 */
public class AdministradorController {
    EntityManagerFactory emf;
    
    public AdministradorController(){
        emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    }
    
    public Administrador buscaUsuario(String correo, String contrasenia){
    
    Administrador adm;
    EntityManager em = emf.createEntityManager();
    String consulta = "SELECT u FROM Administrador u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";
    Query query = em.createQuery(consulta);
    query.setParameter("correo", correo);
    query.setParameter("contrasenia", contrasenia);
    List list = query.getResultList();
    if(list.size() > 0){
    adm = (Administrador)list.get(0);
    return adm;
    }else{
        return null;
    }
  
    }
    
    
    
    
}
