/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import entidad.Comentario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidad.Usuario;
import entidad.Puesto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mint
 */
public class ComentarioJpaController implements Serializable {

    public ComentarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comentario comentario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario NIdUsuario = comentario.getNIdUsuario();
            if (NIdUsuario != null) {
                NIdUsuario = em.getReference(NIdUsuario.getClass(), NIdUsuario.getNIdUsuario());
                comentario.setNIdUsuario(NIdUsuario);
            }
            Puesto NIdPuesto = comentario.getNIdPuesto();
            if (NIdPuesto != null) {
                NIdPuesto = em.getReference(NIdPuesto.getClass(), NIdPuesto.getNIdPuesto());
                comentario.setNIdPuesto(NIdPuesto);
            }
            em.persist(comentario);
            if (NIdUsuario != null) {
                NIdUsuario.getComentarioList().add(comentario);
                NIdUsuario = em.merge(NIdUsuario);
            }
            if (NIdPuesto != null) {
                NIdPuesto.getComentarioList().add(comentario);
                NIdPuesto = em.merge(NIdPuesto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario persistentComentario = em.find(Comentario.class, comentario.getNIdComentario());
            Usuario NIdUsuarioOld = persistentComentario.getNIdUsuario();
            Usuario NIdUsuarioNew = comentario.getNIdUsuario();
            Puesto NIdPuestoOld = persistentComentario.getNIdPuesto();
            Puesto NIdPuestoNew = comentario.getNIdPuesto();
            if (NIdUsuarioNew != null) {
                NIdUsuarioNew = em.getReference(NIdUsuarioNew.getClass(), NIdUsuarioNew.getNIdUsuario());
                comentario.setNIdUsuario(NIdUsuarioNew);
            }
            if (NIdPuestoNew != null) {
                NIdPuestoNew = em.getReference(NIdPuestoNew.getClass(), NIdPuestoNew.getNIdPuesto());
                comentario.setNIdPuesto(NIdPuestoNew);
            }
            comentario = em.merge(comentario);
            if (NIdUsuarioOld != null && !NIdUsuarioOld.equals(NIdUsuarioNew)) {
                NIdUsuarioOld.getComentarioList().remove(comentario);
                NIdUsuarioOld = em.merge(NIdUsuarioOld);
            }
            if (NIdUsuarioNew != null && !NIdUsuarioNew.equals(NIdUsuarioOld)) {
                NIdUsuarioNew.getComentarioList().add(comentario);
                NIdUsuarioNew = em.merge(NIdUsuarioNew);
            }
            if (NIdPuestoOld != null && !NIdPuestoOld.equals(NIdPuestoNew)) {
                NIdPuestoOld.getComentarioList().remove(comentario);
                NIdPuestoOld = em.merge(NIdPuestoOld);
            }
            if (NIdPuestoNew != null && !NIdPuestoNew.equals(NIdPuestoOld)) {
                NIdPuestoNew.getComentarioList().add(comentario);
                NIdPuestoNew = em.merge(NIdPuestoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comentario.getNIdComentario();
                if (findComentario(id) == null) {
                    throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario comentario;
            try {
                comentario = em.getReference(Comentario.class, id);
                comentario.getNIdComentario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.", enfe);
            }
            Usuario NIdUsuario = comentario.getNIdUsuario();
            if (NIdUsuario != null) {
                NIdUsuario.getComentarioList().remove(comentario);
                NIdUsuario = em.merge(NIdUsuario);
            }
            Puesto NIdPuesto = comentario.getNIdPuesto();
            if (NIdPuesto != null) {
                NIdPuesto.getComentarioList().remove(comentario);
                NIdPuesto = em.merge(NIdPuesto);
            }
            em.remove(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comentario> findComentarioEntities() {
        return findComentarioEntities(true, -1, -1);
    }

    public List<Comentario> findComentarioEntities(int maxResults, int firstResult) {
        return findComentarioEntities(false, maxResults, firstResult);
    }

    private List<Comentario> findComentarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comentario.class));
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

    public Comentario findComentario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comentario.class, id);
        } finally {
            em.close();
        }
    }

    public int getComentarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comentario> rt = cq.from(Comentario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
