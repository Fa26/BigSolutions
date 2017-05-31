/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author carloazul21
 */
public class UsuarioController {
    EntityManagerFactory emf;
    
    public UsuarioController(){
        emf = Persistence.createEntityManagerFactory("FoodCienciasPU");
    }
    
    public Usuario buscaUsuario(String correo, String contrasenia){
    
    Usuario usr;
    EntityManager em = emf.createEntityManager();
    String consulta = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";
    Query query = em.createQuery(consulta);
    query.setParameter("correo", correo);
    query.setParameter("contrasenia", contrasenia);
    List list = query.getResultList();
    if(list.size() > 0){
    usr = (Usuario)list.get(0);
    return usr;
    }else{
        return null;
    }
     
    
    }
    
}
