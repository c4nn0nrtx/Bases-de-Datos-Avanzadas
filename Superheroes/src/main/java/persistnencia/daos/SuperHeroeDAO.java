package persistnencia.daos;

import dominio.entidades.SuperHeroe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import persistnencia.interfaces.ISuperHeroeDAO;
import util.JPAUtil;

/**
 *
 * @author brand
 */
public class SuperHeroeDAO implements ISuperHeroeDAO {

    // El DAO obtiene el EntityManager a través de JPAUtil
    @Override
    public void insertar(SuperHeroe e) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(e);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error al insertar superhéroe: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(SuperHeroe e) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            // merge es utilizado para actualizar entidades
            em.merge(e);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error al actualizar superhéroe: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            SuperHeroe heroe = em.find(SuperHeroe.class, id);
            if (heroe != null) {
                em.remove(heroe);
            }
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error al eliminar superhéroe: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public SuperHeroe buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(SuperHeroe.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<SuperHeroe> obtenerTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT sh FROM SuperHeroe sh").getResultList();
        } finally {
            em.close();
        }
    }
}
