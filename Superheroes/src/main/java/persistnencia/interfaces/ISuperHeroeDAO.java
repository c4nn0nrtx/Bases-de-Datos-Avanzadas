package persistnencia.interfaces;

import dominio.entidades.SuperHeroe;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ISuperHeroeDAO {

    void insertar(SuperHeroe e);

    void actualizar(SuperHeroe e);

    void eliminar(Long id);

    SuperHeroe buscar(Long id);

    List<SuperHeroe> obtenerTodos();
}
