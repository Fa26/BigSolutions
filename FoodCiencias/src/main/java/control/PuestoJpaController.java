/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.IllegalOrphanException;
import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidad.Administrador;
import entidad.Calificacion;
import java.util.ArrayList;
import java.util.Collection;
import entidad.Comentario;
import entidad.Puesto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mint
 */
public class PuestoJpaController implements Serializable {

    public PuestoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puesto puesto) {
        if (puesto.getCalificacionCollection() == null) {
            puesto.setCalificacionCollection(new ArrayList<Calificacion>());
        }
        if (puesto.getComentarioCollection() == null) {
            puesto.setComentarioCollection(new ArrayList<Comentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador NIdAdministrador = puesto.getNIdAdministrador();
            if (NIdAdministrador != null) {
                NIdAdministrador = em.getReference(NIdAdministrador.getClass(), NIdAdministrador.getNIdAdministrador());
                puesto.setNIdAdministrador(NIdAdministrador);
            }
            Collection<Calificacion> attachedCalificacionCollection = new ArrayList<Calificacion>();
            for (Calificacion calificacionCollectionCalificacionToAttach : puesto.getCalificacionCollection()) {
                calificacionCollectionCalificacionToAttach = em.getReference(calificacionCollectionCalificacionToAttach.getClass(), calificacionCollectionCalificacionToAttach.getCalificacionPK());
                attachedCalificacionCollection.add(calificacionCollectionCalificacionToAttach);
            }
            puesto.setCalificacionCollection(attachedCalificacionCollection);
            Collection<Comentario> attachedComentarioCollection = new ArrayList<Comentario>();
            for (Comentario comentarioCollectionComentarioToAttach : puesto.getComentarioCollection()) {
                comentarioCollectionComentarioToAttach = em.getReference(comentarioCollectionComentarioToAttach.getClass(), comentarioCollectionComentarioToAttach.getNIdComentario());
                attachedComentarioCollection.add(comentarioCollectionComentarioToAttach);
            }
            puesto.setComentarioCollection(attachedComentarioCollection);
            em.persist(puesto);
            if (NIdAdministrador != null) {
                NIdAdministrador.getPuestoCollection().add(puesto);
                NIdAdministrador = em.merge(NIdAdministrador);
            }
            for (Calificacion calificacionCollectionCalificacion : puesto.getCalificacionCollection()) {
                Puesto oldPuestoOfCalificacionCollectionCalificacion = calificacionCollectionCalificacion.getPuesto();
                calificacionCollectionCalificacion.setPuesto(puesto);
                calificacionCollectionCalificacion = em.merge(calificacionCollectionCalificacion);
                if (oldPuestoOfCalificacionCollectionCalificacion != null) {
                    oldPuestoOfCalificacionCollectionCalificacion.getCalificacionCollection().remove(calificacionCollectionCalificacion);
                    oldPuestoOfCalificacionCollectionCalificacion = em.merge(oldPuestoOfCalificacionCollectionCalificacion);
                }
            }
            for (Comentario comentarioCollectionComentario : puesto.getComentarioCollection()) {
                Puesto oldNIdPuestoOfComentarioCollectionComentario = comentarioCollectionComentario.getNIdPuesto();
                comentarioCollectionComentario.setNIdPuesto(puesto);
                comentarioCollectionComentario = em.merge(comentarioCollectionComentario);
                if (oldNIdPuestoOfComentarioCollectionComentario != null) {
                    oldNIdPuestoOfComentarioCollectionComentario.getComentarioCollection().remove(comentarioCollectionComentario);
                    oldNIdPuestoOfComentarioCollectionComentario = em.merge(oldNIdPuestoOfComentarioCollectionComentario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puesto puesto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto persistentPuesto = em.find(Puesto.class, puesto.getNIdPuesto());
            Administrador NIdAdministradorOld = persistentPuesto.getNIdAdministrador();
            Administrador NIdAdministradorNew = puesto.getNIdAdministrador();
            Collection<Calificacion> calificacionCollectionOld = persistentPuesto.getCalificacionCollection();
            Collection<Calificacion> calificacionCollectionNew = puesto.getCalificacionCollection();
            Collection<Comentario> comentarioCollectionOld = persistentPuesto.getComentarioCollection();
            Collection<Comentario> comentarioCollectionNew = puesto.getComentarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Calificacion calificacionCollectionOldCalificacion : calificacionCollectionOld) {
                if (!calificacionCollectionNew.contains(calificacionCollectionOldCalificacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calificacion " + calificacionCollectionOldCalificacion + " since its puesto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (NIdAdministradorNew != null) {
                NIdAdministradorNew = em.getReference(NIdAdministradorNew.getClass(), NIdAdministradorNew.getNIdAdministrador());
                puesto.setNIdAdministrador(NIdAdministradorNew);
            }
            Collection<Calificacion> attachedCalificacionCollectionNew = new ArrayList<Calificacion>();
            for (Calificacion calificacionCollectionNewCalificacionToAttach : calificacionCollectionNew) {
                calificacionCollectionNewCalificacionToAttach = em.getReference(calificacionCollectionNewCalificacionToAttach.getClass(), calificacionCollectionNewCalificacionToAttach.getCalificacionPK());
                attachedCalificacionCollectionNew.add(calificacionCollectionNewCalificacionToAttach);
            }
            calificacionCollectionNew = attachedCalificacionCollectionNew;
            puesto.setCalificacionCollection(calificacionCollectionNew);
            Collection<Comentario> attachedComentarioCollectionNew = new ArrayList<Comentario>();
            for (Comentario comentarioCollectionNewComentarioToAttach : comentarioCollectionNew) {
                comentarioCollectionNewComentarioToAttach = em.getReference(comentarioCollectionNewComentarioToAttach.getClass(), comentarioCollectionNewComentarioToAttach.getNIdComentario());
                attachedComentarioCollectionNew.add(comentarioCollectionNewComentarioToAttach);
            }
            comentarioCollectionNew = attachedComentarioCollectionNew;
            puesto.setComentarioCollection(comentarioCollectionNew);
            puesto = em.merge(puesto);
            if (NIdAdministradorOld != null && !NIdAdministradorOld.equals(NIdAdministradorNew)) {
                NIdAdministradorOld.getPuestoCollection().remove(puesto);
                NIdAdministradorOld = em.merge(NIdAdministradorOld);
            }
            if (NIdAdministradorNew != null && !NIdAdministradorNew.equals(NIdAdministradorOld)) {
                NIdAdministradorNew.getPuestoCollection().add(puesto);
                NIdAdministradorNew = em.merge(NIdAdministradorNew);
            }
            for (Calificacion calificacionCollectionNewCalificacion : calificacionCollectionNew) {
                if (!calificacionCollectionOld.contains(calificacionCollectionNewCalificacion)) {
                    Puesto oldPuestoOfCalificacionCollectionNewCalificacion = calificacionCollectionNewCalificacion.getPuesto();
                    calificacionCollectionNewCalificacion.setPuesto(puesto);
                    calificacionCollectionNewCalificacion = em.merge(calificacionCollectionNewCalificacion);
                    if (oldPuestoOfCalificacionCollectionNewCalificacion != null && !oldPuestoOfCalificacionCollectionNewCalificacion.equals(puesto)) {
                        oldPuestoOfCalificacionCollectionNewCalificacion.getCalificacionCollection().remove(calificacionCollectionNewCalificacion);
                        oldPuestoOfCalificacionCollectionNewCalificacion = em.merge(oldPuestoOfCalificacionCollectionNewCalificacion);
                    }
                }
            }
            for (Comentario comentarioCollectionOldComentario : comentarioCollectionOld) {
                if (!comentarioCollectionNew.contains(comentarioCollectionOldComentario)) {
                    comentarioCollectionOldComentario.setNIdPuesto(null);
                    comentarioCollectionOldComentario = em.merge(comentarioCollectionOldComentario);
                }
            }
            for (Comentario comentarioCollectionNewComentario : comentarioCollectionNew) {
                if (!comentarioCollectionOld.contains(comentarioCollectionNewComentario)) {
                    Puesto oldNIdPuestoOfComentarioCollectionNewComentario = comentarioCollectionNewComentario.getNIdPuesto();
                    comentarioCollectionNewComentario.setNIdPuesto(puesto);
                    comentarioCollectionNewComentario = em.merge(comentarioCollectionNewComentario);
                    if (oldNIdPuestoOfComentarioCollectionNewComentario != null && !oldNIdPuestoOfComentarioCollectionNewComentario.equals(puesto)) {
                        oldNIdPuestoOfComentarioCollectionNewComentario.getComentarioCollection().remove(comentarioCollectionNewComentario);
                        oldNIdPuestoOfComentarioCollectionNewComentario = em.merge(oldNIdPuestoOfComentarioCollectionNewComentario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = puesto.getNIdPuesto();
                if (findPuesto(id) == null) {
                    throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto puesto;
            try {
                puesto = em.getReference(Puesto.class, id);
                puesto.getNIdPuesto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Calificacion> calificacionCollectionOrphanCheck = puesto.getCalificacionCollection();
            for (Calificacion calificacionCollectionOrphanCheckCalificacion : calificacionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Puesto (" + puesto + ") cannot be destroyed since the Calificacion " + calificacionCollectionOrphanCheckCalificacion + " in its calificacionCollection field has a non-nullable puesto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Administrador NIdAdministrador = puesto.getNIdAdministrador();
            if (NIdAdministrador != null) {
                NIdAdministrador.getPuestoCollection().remove(puesto);
                NIdAdministrador = em.merge(NIdAdministrador);
            }
            Collection<Comentario> comentarioCollection = puesto.getComentarioCollection();
            for (Comentario comentarioCollectionComentario : comentarioCollection) {
                comentarioCollectionComentario.setNIdPuesto(null);
                comentarioCollectionComentario = em.merge(comentarioCollectionComentario);
            }
            em.remove(puesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puesto> findPuestoEntities() {
        return findPuestoEntities(true, -1, -1);
    }

    public List<Puesto> findPuestoEntities(int maxResults, int firstResult) {
        return findPuestoEntities(false, maxResults, firstResult);
    }

    private List<Puesto> findPuestoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puesto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Puesto findPuesto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puesto.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuestoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puesto> rt = cq.from(Puesto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
