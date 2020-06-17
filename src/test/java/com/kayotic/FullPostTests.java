package com.kayotic;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class FullPostTests {

    @Test
    void showEntityManagerIsNotNull() {
        String persistentUnit = "kayoticpu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);
        EntityManager em = emf.createEntityManager();

        assertThat(em).isNotNull();

    }

    @Test
    void saveFullPostInDatabase() {
        String persistentUnit = "kayoticpu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
            em.persist(new FullPost(1,"Smullen met pannekoeken"));
        em.getTransaction().commit();
    }

    @Test
    void saveFullPostInDatabaseAndUpdateItAferwards() {
        String persistentUnit = "kayoticpu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
            FullPost smullen_met_pannekoeken = new FullPost(1, "Smullen met pannekoeken");
            em.persist(smullen_met_pannekoeken);
        em.getTransaction().commit();

        em.getTransaction().begin();
            //We hebben hier een referentie naar een entity die gemaneged is.
            smullen_met_pannekoeken.setTitle("Nog meer Smullen met pannekoeken");

        em.getTransaction().commit();
    }

    @Test
    void changeFullPostInDatabaseAfterPersist() {
        String persistentUnit = "kayoticpu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);
        EntityManager em = emf.createEntityManager();

        FullPost smullen_met_pannekoeken = new FullPost(1, "Smullen met pannekoeken");
        smullen_met_pannekoeken.setTitle("Nog meer Smullen met pannekoeken");
        em.persist(smullen_met_pannekoeken);


        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
