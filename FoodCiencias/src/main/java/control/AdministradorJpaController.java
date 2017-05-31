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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author leo
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
        if (administrador.getPuestoList() == null) {
            administrador.setPuestoList(new ArrayList<Puesto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Puesto> attachedPuestoList = new ArrayList<Puesto>();
            for (Puesto puestoListPuestoToAttach : administrador.getPuestoList()) {
                puestoListPuestoToAttach = em.getReference(puestoListPuestoToAttach.getClass(), puestoListPuestoToAttach.getNIdPuesto());
                attachedPuestoList.add(puestoListPuestoToAttach);
            }
            administrador.setPuestoList(attachedPuestoList);
            em.persist(administrador);
            for (Puesto puestoListPuesto : administrador.getPuestoList()) {
                Administrador oldNIdAdministradorOfPuestoListPuesto = puestoListPuesto.getNIdAdministrador();
                puestoListPuesto.setNIdAdministrador(administrador);
                puestoListPuesto = em.merge(puestoListPuesto);
                if (oldNIdAdministradorOfPuestoListPuesto != null) {
                    oldNIdAdministradorOfPuestoListPuesto.getPuestoList().remove(puestoListPuesto);
                    oldNIdAdministradorOfPuestoListPuesto = em.merge(oldNIdAdministradorOfPuestoListPuesto);
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
            List<Puesto> puestoListOld = persistentAdministrador.getPuestoList();
            List<Puesto> puestoListNew = administrador.getPuestoList();
            List<Puesto> attachedPuestoListNew = new ArrayList<Puesto>();
            for (Puesto puestoListNewPuestoToAttach : puestoListNew) {
                puestoListNewPuestoToAttach = em.getReference(puestoListNewPuestoToAttach.getClass(), puestoListNewPuestoToAttach.getNIdPuesto());
                attachedPuestoListNew.add(puestoListNewPuestoToAttach);
            }
            puestoListNew = attachedPuestoListNew;
            administrador.setPuestoList(puestoListNew);
            administrador = em.merge(administrador);
            for (Puesto puestoListOldPuesto : puestoListOld) {
                if (!puestoListNew.contains(puestoListOldPuesto)) {
                    puestoListOldPuesto.setNIdAdministrador(null);
                    puestoListOldPuesto = em.merge(puestoListOldPuesto);
                }
            }
            for (Puesto puestoListNewPuesto : puestoListNew) {
                if (!puestoListOld.contains(puestoListNewPuesto)) {
                    Administrador oldNIdAdministradorOfPuestoListNewPuesto = puestoListNewPuesto.getNIdAdministrador();
                    puestoListNewPuesto.setNIdAdministrador(administrador);
                    puestoListNewPuesto = em.merge(puestoListNewPuesto);
                    if (oldNIdAdministradorOfPuestoListNewPuesto != null && !oldNIdAdministradorOfPuestoListNewPuesto.equals(administrador)) {
                        oldNIdAdministradorOfPuestoListNewPuesto.getPuestoList().remove(puestoListNewPuesto);
                        oldNIdAdministradorOfPuestoListNewPuesto = em.merge(oldNIdAdministradorOfPuestoListNewPuesto);
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
            List<Puesto> puestoList = administrador.getPuestoList();
            for (Puesto puestoListPuesto : puestoList) {
                puestoListPuesto.setNIdAdministrador(null);
                puestoListPuesto = em.merge(puestoListPuesto);
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
