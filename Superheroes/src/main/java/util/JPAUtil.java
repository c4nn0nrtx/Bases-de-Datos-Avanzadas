package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author brand
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "SuperHeroesPU";

    // EntityManagerFactory es un recurso pesado, debe ser Singleton y Thread-safe
    private static EntityManagerFactory factory;

    // Bloque estático para inicializar la fábrica una sola vez
    static {
        try {

            // Se inicializa al cargar la clase
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            System.out.println("EntityManagerFactory inicializado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al inicializar EntityManagerFactory: " + e.getMessage());

            // Manejo de error severo: propagar o detener la aplicación
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Provee una instancia de EntityManager. EntityManager NO es thread-safe y
     * debe crearse para cada unidad de trabajo (DAO, Service).
     *
     * @return Una nueva instancia de EntityManager.
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    /**
     * Cierra la EntityManagerFactory cuando la aplicación finaliza.
     */
    public static void cerrar() {
        if (factory != null && factory.isOpen()) {
            factory.close();
            System.out.println("EntityManagerFactory cerrado.");
        }
    }

    private JPAUtil() {
    }
}
