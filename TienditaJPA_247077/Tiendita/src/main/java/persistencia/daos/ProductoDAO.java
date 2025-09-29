package persistencia.daos;

import dominio.Entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IProductoDAO;

/**
 *
 * @author brand
 */
public class ProductoDAO implements IProductoDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TienditaPU");

    @Override
    public void insertar(Producto p) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al insertar producto", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Producto buscar(Long id) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Producto.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar producto con id=" + id, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> listar() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p", Producto.class);
            return q.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar productos", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Producto p) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar producto con id=" + p.getId(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar producto con id=" + id, e);
        } finally {
            em.close();
        }
    }

    @Override
    public void close() throws PersistenciaException {
        try {
            if (emf.isOpen()) {
                emf.close();
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al cerrar EntityManagerFactory", e);
        }
    }
}
