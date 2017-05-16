/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import entidad.Administrador;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidad.Puesto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mint
 */
public class AdministradorJpaController implements Serializable {

    public AdministradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrador administrador) {
        if (administrador.getPuestoCollection() == null) {
            administrador.setPuestoCollection(new ArrayList<Puesto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Puesto> attachedPuestoCollection = new ArrayList<Puesto>();
            for (Puesto puestoCollectionPuestoToAttach : administrador.getPuestoCollection()) {
                puestoCollectionPuestoToAttach = em.getReference(puestoCollectionPuestoToAttach.getClass(), puestoCollectionPuestoToAttach.getNIdPuesto());
                attachedPuestoCollection.add(puestoCollectionPuestoToAttach);
            }
            administrador.setPuestoCollection(attachedPuestoCollection);
            em.persist(administrador);
            for (Puesto puestoCollectionPuesto : administrador.getPuestoCollection()) {
                Administrador oldNIdAdministradorOfPuestoCollectionPuesto = puestoCollectionPuesto.getNIdAdministrador();
                puestoCollectionPuesto.setNIdAdministrador(administrador);
                puestoCollectionPuesto = em.merge(puestoCollectionPuesto);
                if (oldNIdAdministradorOfPuestoCollectionPuesto != null) {
                    oldNIdAdministradorOfPuestoCollectionPuesto.getPuestoCollection().remove(puestoCollectionPuesto);
                    oldNIdAdministradorOfPuestoCollectionPuesto = em.merge(oldNIdAdministradorOfPuestoCollectionPuesto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrador administrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador persistentAdministrador = em.find(Administrador.class, administrador.getNIdAdministrador());
            Collection<Puesto> puestoCollectionOld = persistentAdministrador.getPuestoCollection();
            Collection<Puesto> puestoCollectionNew = administrador.getPuestoCollection();
            Collection<Puesto> attachedPuestoCollectionNew = new ArrayList<Puesto>();
            for (Puesto puestoCollectionNewPuestoToAttach : puestoCollectionNew) {
                puestoCollectionNewPuestoToAttach = em.getReference(puestoCollectionNewPuestoToAttach.getClass(), puestoCollectionNewPuestoToAttach.getNIdPuesto());
                attachedPuestoCollectionNew.add(puestoCollectionNewPuestoToAttach);
            }
            puestoCollectionNew = attachedPuestoCollectionNew;
            administrador.setPuestoCollection(puestoCollectionNew);
            administrador = em.merge(administrador);
            for (Puesto puestoCollectionOldPuesto : puestoCollectionOld) {
                if (!puestoCollectionNew.contains(puestoCollectionOldPuesto)) {
                    puestoCollectionOldPuesto.setNIdAdministrador(null);
                    puestoCollectionOldPuesto = em.merge(puestoCollectionOldPuesto);
                }
            }
            for (Puesto puestoCollectionNewPuesto : puestoCollectionNew) {
                if (!puestoCollectionOld.contains(puestoCollectionNewPuesto)) {
                    Administrador oldNIdAdministradorOfPuestoCollectionNewPuesto = puestoCollectionNewPuesto.getNIdAdministrador();
                    puestoCollectionNewPuesto.setNIdAdministrador(administrador);
                    puestoCollectionNewPuesto = em.merge(puestoCollectionNewPuesto);
                    if (oldNIdAdministradorOfPuestoCollectionNewPuesto != null && !oldNIdAdministradorOfPuestoCollectionNewPuesto.equals(administrador)) {
                        oldNIdAdministradorOfPuestoCollectionNewPuesto.getPuestoCollection().remove(puestoCollectionNewPuesto);
                        oldNIdAdministradorOfPuestoCollectionNewPuesto = em.merge(oldNIdAdministradorOfPuestoCollectionNewPuesto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administrador.getNIdAdministrador();
                if (findAdministrador(id) == null) {
                    throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.");
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
            Administrador administrador;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getNIdAdministrador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.", enfe);
            }
            Collection<Puesto> puestoCollection = administrador.getPuestoCollection();
            for (Puesto puestoCollectionPuesto : puestoCollection) {
                puestoCollectionPuesto.setNIdAdministrador(null);
                puestoCollectionPuesto = em.merge(puestoCollectionPuesto);
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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

    public Administrador findAdministrador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrador> rt = cq.from(Administrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
