/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import entidad.Alimento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author FaVenegas
 */
public class AlimentoJpaController implements Serializable {

    public AlimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alimento alimento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlimento(alimento.getNIdAlimento()) != null) {
                throw new PreexistingEntityException("Alimento " + alimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alimento alimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alimento = em.merge(alimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alimento.getNIdAlimento();
                if (findAlimento(id) == null) {
                    throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.");
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
            Alimento alimento;
            try {
                alimento = em.getReference(Alimento.class, id);
                alimento.getNIdAlimento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(alimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alimento> findAlimentoEntities() {
        return findAlimentoEntities(true, -1, -1);
    }

    public List<Alimento> findAlimentoEntities(int maxResults, int firstResult) {
        return findAlimentoEntities(false, maxResults, firstResult);
    }

    private List<Alimento> findAlimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alimento.class));
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

    public Alimento findAlimento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alimento> rt = cq.from(Alimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
