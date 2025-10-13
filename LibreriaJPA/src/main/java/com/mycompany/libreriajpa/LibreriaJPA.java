package com.mycompany.libreriajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author brand
 */
public class LibreriaJPA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emf.createEntityManager();
    }
}
