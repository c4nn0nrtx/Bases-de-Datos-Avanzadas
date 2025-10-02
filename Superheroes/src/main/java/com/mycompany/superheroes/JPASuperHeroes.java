package com.mycompany.superheroes;

import dominio.entidades.IdentidadSecreta;
import dominio.entidades.SuperHeroe;
import dominio.entidades.Universo;
import java.util.List;
import persistnencia.daos.SuperHeroeDAO;
import util.JPAUtil;

/**
 *
 * @author brand
 */
public class JPASuperHeroes {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SuperHeroeDAO dao = new SuperHeroeDAO();

        try {
            // 1. Insertar algunos superhéroes de prueba
            System.out.println("--- 1. Insertando Superhéroes ---");

            SuperHeroe spiderman = new SuperHeroe(
                    "Spider-Man",
                    Universo.MARVEL,
                    new IdentidadSecreta(
                            "Peter Parker",
                            "Nueva York",
                            "Fotógrafo"),
                    "Un gran poder conlleva una gran responsabilidad.");
            dao.insertar(spiderman);

            SuperHeroe batman = new SuperHeroe(
                    "Batman",
                    Universo.DC,
                    new IdentidadSecreta(
                            "Bruce Wayne",
                            "Gotham",
                            "Empresario"),
                    "Soy la noche.");
            dao.insertar(batman);

            SuperHeroe chapulinColorado = new SuperHeroe(
                    "El Chapulin Colorado",
                    Universo.INDEPENDIENTE,
                    new IdentidadSecreta(
                            "Chavito",
                            "La Vecindad",
                            "Vendedor de aguas"),
                    "Si le sigues te parto todo lo que se llama cara");
            dao.insertar(chapulinColorado);

            System.out.println("Insertados: " + spiderman.getNombre() + ", " + batman.getNombre() + ", " + chapulinColorado.getNombre());

            // 2. Listar todos los superhéroes
            System.out.println("\n--- 2. Listado Inicial de Superhéroes ---");
            listarHeroes(dao);

            // Buscar un héroe para modificar
            SuperHeroe heroeModificar = dao.buscar(batman.getId());
            if (heroeModificar != null) {
                // 3. Modificar un superhéroe
                System.out.println("\n--- 3. Modificando Superhéroe (Batman) ---");
                heroeModificar.setNombre("El Caballero Oscuro (Batman)");
                heroeModificar.getIdentidadSecreta().setOcupacion("Justiciero");
                dao.actualizar(heroeModificar);

                System.out.println("Héroe modificado. Nuevo nombre: " + heroeModificar.getNombre());
            }

            // Listar nuevamente para ver la modificación
            System.out.println("\n--- 4. Listado después de la Modificación ---");
            listarHeroes(dao);

            // 5. Eliminar un superhéroe
            System.out.println("\n--- 5. Eliminando Superhéroe (El Chapulin Colorado) ---");
            Long idAEliminar = chapulinColorado.getId();
            dao.eliminar(idAEliminar);
            System.out.println("Superhéroe con ID " + idAEliminar + " eliminado.");

            // Listar nuevamente para ver la eliminación
            System.out.println("\n--- 6. Listado después de la Eliminación ---");
            listarHeroes(dao);

        } catch (Exception e) {
            System.err.println("Ocurrió un error en la prueba del CRUD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la fábrica de EntityManagers al finalizar la aplicación
            JPAUtil.cerrar();
        }
    }

    private static void listarHeroes(SuperHeroeDAO dao) {
        List<SuperHeroe> heroes = dao.obtenerTodos();
        if (heroes.isEmpty()) {
            System.out.println("No hay superhéroes en la base de datos.");
        } else {
            heroes.forEach(System.out::println);
        }
    }
}
