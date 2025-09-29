package persistencia.interfaces;

import dominio.Entidades.Producto;
import java.util.List;
import persistencia.exception.PersistenciaException;

/**
 *
 * @author brand
 */
public interface IProductoDAO {

    void insertar(Producto p) throws PersistenciaException;

    Producto buscar(Long id) throws PersistenciaException;

    List<Producto> listar() throws PersistenciaException;

    void actualizar(Producto p) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void close() throws PersistenciaException;
}
