package com.mycompany.dogosobregonjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author brand
 */
public class DogosObregonJPA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosPU");
        EntityManager em = emf.createEntityManager();
    }
}
