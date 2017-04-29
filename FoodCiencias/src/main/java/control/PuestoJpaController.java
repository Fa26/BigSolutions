/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidad.Administrador;
import entidad.Comentario;
import entidad.Puesto;
import java.util.ArrayList;
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
        if (puesto.getComentarioList() == null) {
            puesto.setComentarioList(new ArrayList<Comentario>());
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
            List<Comentario> attachedComentarioList = new ArrayList<Comentario>();
            for (Comentario comentarioListComentarioToAttach : puesto.getComentarioList()) {
                comentarioListComentarioToAttach = em.getReference(comentarioListComentarioToAttach.getClass(), comentarioListComentarioToAttach.getNIdComentario());
                attachedComentarioList.add(comentarioListComentarioToAttach);
            }
            puesto.setComentarioList(attachedComentarioList);
            em.persist(puesto);
            if (NIdAdministrador != null) {
                NIdAdministrador.getPuestoList().add(puesto);
                NIdAdministrador = em.merge(NIdAdministrador);
            }
            for (Comentario comentarioListComentario : puesto.getComentarioList()) {
                Puesto oldNIdPuestoOfComentarioListComentario = comentarioListComentario.getNIdPuesto();
                comentarioListComentario.setNIdPuesto(puesto);
                comentarioListComentario = em.merge(comentarioListComentario);
                if (oldNIdPuestoOfComentarioListComentario != null) {
                    oldNIdPuestoOfComentarioListComentario.getComentarioList().remove(comentarioListComentario);
                    oldNIdPuestoOfComentarioListComentario = em.merge(oldNIdPuestoOfComentarioListComentario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puesto puesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto persistentPuesto = em.find(Puesto.class, puesto.getNIdPuesto());
            Administrador NIdAdministradorOld = persistentPuesto.getNIdAdministrador();
            Administrador NIdAdministradorNew = puesto.getNIdAdministrador();
            List<Comentario> comentarioListOld = persistentPuesto.getComentarioList();
            List<Comentario> comentarioListNew = puesto.getComentarioList();
            if (NIdAdministradorNew != null) {
                NIdAdministradorNew = em.getReference(NIdAdministradorNew.getClass(), NIdAdministradorNew.getNIdAdministrador());
                puesto.setNIdAdministrador(NIdAdministradorNew);
            }
            List<Comentario> attachedComentarioListNew = new ArrayList<Comentario>();
            for (Comentario comentarioListNewComentarioToAttach : comentarioListNew) {
                comentarioListNewComentarioToAttach = em.getReference(comentarioListNewComentarioToAttach.getClass(), comentarioListNewComentarioToAttach.getNIdComentario());
                attachedComentarioListNew.add(comentarioListNewComentarioToAttach);
            }
            comentarioListNew = attachedComentarioListNew;
            puesto.setComentarioList(comentarioListNew);
            puesto = em.merge(puesto);
            if (NIdAdministradorOld != null && !NIdAdministradorOld.equals(NIdAdministradorNew)) {
                NIdAdministradorOld.getPuestoList().remove(puesto);
                NIdAdministradorOld = em.merge(NIdAdministradorOld);
            }
            if (NIdAdministradorNew != null && !NIdAdministradorNew.equals(NIdAdministradorOld)) {
                NIdAdministradorNew.getPuestoList().add(puesto);
                NIdAdministradorNew = em.merge(NIdAdministradorNew);
            }
            for (Comentario comentarioListOldComentario : comentarioListOld) {
                if (!comentarioListNew.contains(comentarioListOldComentario)) {
                    comentarioListOldComentario.setNIdPuesto(null);
                    comentarioListOldComentario = em.merge(comentarioListOldComentario);
                }
            }
            for (Comentario comentarioListNewComentario : comentarioListNew) {
                if (!comentarioListOld.contains(comentarioListNewComentario)) {
                    Puesto oldNIdPuestoOfComentarioListNewComentario = comentarioListNewComentario.getNIdPuesto();
                    comentarioListNewComentario.setNIdPuesto(puesto);
                    comentarioListNewComentario = em.merge(comentarioListNewComentario);
                    if (oldNIdPuestoOfComentarioListNewComentario != null && !oldNIdPuestoOfComentarioListNewComentario.equals(puesto)) {
                        oldNIdPuestoOfComentarioListNewComentario.getComentarioList().remove(comentarioListNewComentario);
                        oldNIdPuestoOfComentarioListNewComentario = em.merge(oldNIdPuestoOfComentarioListNewComentario);
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Administrador NIdAdministrador = puesto.getNIdAdministrador();
            if (NIdAdministrador != null) {
                NIdAdministrador.getPuestoList().remove(puesto);
                NIdAdministrador = em.merge(NIdAdministrador);
            }
            List<Comentario> comentarioList = puesto.getComentarioList();
            for (Comentario comentarioListComentario : comentarioList) {
                comentarioListComentario.setNIdPuesto(null);
                comentarioListComentario = em.merge(comentarioListComentario);
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
