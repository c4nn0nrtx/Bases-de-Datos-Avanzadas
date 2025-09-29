package com.mycompany.tiendita;

import dominio.Entidades.Producto;
import java.util.List;
import persistencia.daos.ProductoDAO;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IProductoDAO;

/**
 *
 * @author brand
 */
public class Tiendita {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        IProductoDAO dao = new ProductoDAO();

        try {
            System.out.println("=== INSERTAR PRODUCTOS ===");
            Producto p1 = new Producto("Pan", 12.5);
            Producto p2 = new Producto("Leche", 22.0);
            Producto p3 = new Producto("Arroz", 34.75);

            dao.insertar(p1);
            dao.insertar(p2);
            dao.insertar(p3);

            listarTodos(dao);

            System.out.println("=== MODIFICAR PRODUCTO (Pan -> Pan Integral) ===");
            Producto buscado = dao.buscar(p1.getId());
            if (buscado != null) {
                buscado.setNombre("Pan Integral");
                buscado.setPrecio(14.0);
                dao.actualizar(buscado);
            }

            listarTodos(dao);

            System.out.println("=== ELIMINAR PRODUCTO (Leche) ===");
            dao.eliminar(p2.getId());

            listarTodos(dao);

        } catch (PersistenciaException e) {
            System.err.println("Ocurrió un error en la capa de persistencia: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                dao.close();
            } catch (PersistenciaException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    private static void listarTodos(IProductoDAO dao) throws PersistenciaException {
        List<Producto> lista = dao.listar();
        System.out.println("Productos en BD:");
        for (Producto p : lista) {
            System.out.println(p);
        }
        System.out.println();
    }
}
