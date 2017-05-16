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
import entidad.Calificacion;
import java.util.ArrayList;
import java.util.Collection;
import entidad.Comentario;
import entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mint
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getCalificacionCollection() == null) {
            usuario.setCalificacionCollection(new ArrayList<Calificacion>());
        }
        if (usuario.getComentarioCollection() == null) {
            usuario.setComentarioCollection(new ArrayList<Comentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calificacion> attachedCalificacionCollection = new ArrayList<Calificacion>();
            for (Calificacion calificacionCollectionCalificacionToAttach : usuario.getCalificacionCollection()) {
                calificacionCollectionCalificacionToAttach = em.getReference(calificacionCollectionCalificacionToAttach.getClass(), calificacionCollectionCalificacionToAttach.getCalificacionPK());
                attachedCalificacionCollection.add(calificacionCollectionCalificacionToAttach);
            }
            usuario.setCalificacionCollection(attachedCalificacionCollection);
            Collection<Comentario> attachedComentarioCollection = new ArrayList<Comentario>();
            for (Comentario comentarioCollectionComentarioToAttach : usuario.getComentarioCollection()) {
                comentarioCollectionComentarioToAttach = em.getReference(comentarioCollectionComentarioToAttach.getClass(), comentarioCollectionComentarioToAttach.getNIdComentario());
                attachedComentarioCollection.add(comentarioCollectionComentarioToAttach);
            }
            usuario.setComentarioCollection(attachedComentarioCollection);
            em.persist(usuario);
            for (Calificacion calificacionCollectionCalificacion : usuario.getCalificacionCollection()) {
                Usuario oldUsuarioOfCalificacionCollectionCalificacion = calificacionCollectionCalificacion.getUsuario();
                calificacionCollectionCalificacion.setUsuario(usuario);
                calificacionCollectionCalificacion = em.merge(calificacionCollectionCalificacion);
                if (oldUsuarioOfCalificacionCollectionCalificacion != null) {
                    oldUsuarioOfCalificacionCollectionCalificacion.getCalificacionCollection().remove(calificacionCollectionCalificacion);
                    oldUsuarioOfCalificacionCollectionCalificacion = em.merge(oldUsuarioOfCalificacionCollectionCalificacion);
                }
            }
            for (Comentario comentarioCollectionComentario : usuario.getComentarioCollection()) {
                Usuario oldNIdUsuarioOfComentarioCollectionComentario = comentarioCollectionComentario.getNIdUsuario();
                comentarioCollectionComentario.setNIdUsuario(usuario);
                comentarioCollectionComentario = em.merge(comentarioCollectionComentario);
                if (oldNIdUsuarioOfComentarioCollectionComentario != null) {
                    oldNIdUsuarioOfComentarioCollectionComentario.getComentarioCollection().remove(comentarioCollectionComentario);
                    oldNIdUsuarioOfComentarioCollectionComentario = em.merge(oldNIdUsuarioOfComentarioCollectionComentario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getNIdUsuario());
            Collection<Calificacion> calificacionCollectionOld = persistentUsuario.getCalificacionCollection();
            Collection<Calificacion> calificacionCollectionNew = usuario.getCalificacionCollection();
            Collection<Comentario> comentarioCollectionOld = persistentUsuario.getComentarioCollection();
            Collection<Comentario> comentarioCollectionNew = usuario.getComentarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Calificacion calificacionCollectionOldCalificacion : calificacionCollectionOld) {
                if (!calificacionCollectionNew.contains(calificacionCollectionOldCalificacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calificacion " + calificacionCollectionOldCalificacion + " since its usuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Calificacion> attachedCalificacionCollectionNew = new ArrayList<Calificacion>();
            for (Calificacion calificacionCollectionNewCalificacionToAttach : calificacionCollectionNew) {
                calificacionCollectionNewCalificacionToAttach = em.getReference(calificacionCollectionNewCalificacionToAttach.getClass(), calificacionCollectionNewCalificacionToAttach.getCalificacionPK());
                attachedCalificacionCollectionNew.add(calificacionCollectionNewCalificacionToAttach);
            }
            calificacionCollectionNew = attachedCalificacionCollectionNew;
            usuario.setCalificacionCollection(calificacionCollectionNew);
            Collection<Comentario> attachedComentarioCollectionNew = new ArrayList<Comentario>();
            for (Comentario comentarioCollectionNewComentarioToAttach : comentarioCollectionNew) {
                comentarioCollectionNewComentarioToAttach = em.getReference(comentarioCollectionNewComentarioToAttach.getClass(), comentarioCollectionNewComentarioToAttach.getNIdComentario());
                attachedComentarioCollectionNew.add(comentarioCollectionNewComentarioToAttach);
            }
            comentarioCollectionNew = attachedComentarioCollectionNew;
            usuario.setComentarioCollection(comentarioCollectionNew);
            usuario = em.merge(usuario);
            for (Calificacion calificacionCollectionNewCalificacion : calificacionCollectionNew) {
                if (!calificacionCollectionOld.contains(calificacionCollectionNewCalificacion)) {
                    Usuario oldUsuarioOfCalificacionCollectionNewCalificacion = calificacionCollectionNewCalificacion.getUsuario();
                    calificacionCollectionNewCalificacion.setUsuario(usuario);
                    calificacionCollectionNewCalificacion = em.merge(calificacionCollectionNewCalificacion);
                    if (oldUsuarioOfCalificacionCollectionNewCalificacion != null && !oldUsuarioOfCalificacionCollectionNewCalificacion.equals(usuario)) {
                        oldUsuarioOfCalificacionCollectionNewCalificacion.getCalificacionCollection().remove(calificacionCollectionNewCalificacion);
                        oldUsuarioOfCalificacionCollectionNewCalificacion = em.merge(oldUsuarioOfCalificacionCollectionNewCalificacion);
                    }
                }
            }
            for (Comentario comentarioCollectionOldComentario : comentarioCollectionOld) {
                if (!comentarioCollectionNew.contains(comentarioCollectionOldComentario)) {
                    comentarioCollectionOldComentario.setNIdUsuario(null);
                    comentarioCollectionOldComentario = em.merge(comentarioCollectionOldComentario);
                }
            }
            for (Comentario comentarioCollectionNewComentario : comentarioCollectionNew) {
                if (!comentarioCollectionOld.contains(comentarioCollectionNewComentario)) {
                    Usuario oldNIdUsuarioOfComentarioCollectionNewComentario = comentarioCollectionNewComentario.getNIdUsuario();
                    comentarioCollectionNewComentario.setNIdUsuario(usuario);
                    comentarioCollectionNewComentario = em.merge(comentarioCollectionNewComentario);
                    if (oldNIdUsuarioOfComentarioCollectionNewComentario != null && !oldNIdUsuarioOfComentarioCollectionNewComentario.equals(usuario)) {
                        oldNIdUsuarioOfComentarioCollectionNewComentario.getComentarioCollection().remove(comentarioCollectionNewComentario);
                        oldNIdUsuarioOfComentarioCollectionNewComentario = em.merge(oldNIdUsuarioOfComentarioCollectionNewComentario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getNIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getNIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Calificacion> calificacionCollectionOrphanCheck = usuario.getCalificacionCollection();
            for (Calificacion calificacionCollectionOrphanCheckCalificacion : calificacionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Calificacion " + calificacionCollectionOrphanCheckCalificacion + " in its calificacionCollection field has a non-nullable usuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Comentario> comentarioCollection = usuario.getComentarioCollection();
            for (Comentario comentarioCollectionComentario : comentarioCollection) {
                comentarioCollectionComentario.setNIdUsuario(null);
                comentarioCollectionComentario = em.merge(comentarioCollectionComentario);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
