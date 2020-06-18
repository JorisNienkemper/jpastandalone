package com.kayotic.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FullPostWihtJPAStandaloneTests {

    private  EntityManagerFactory emf;
    private EntityManager em;


    @BeforeEach
    public void setUpEachTime(){
        String persistentUnit = "kayoticpu";
        emf = Persistence.createEntityManagerFactory(persistentUnit);
        em = emf.createEntityManager();
    }
    @Test
    void showEntityManagerIsNotNull() {
        assertThat(em).isNotNull();
    }



    @Test
    void saveFullPostInDatabaseAndUpdateItAferwards() {
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
        FullPost smullen_met_pannekoeken = new FullPost(1, "Smullen met pannekoeken");
        smullen_met_pannekoeken.setTitle("Nog meer Smullen met pannekoeken");
        em.persist(smullen_met_pannekoeken);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    @Test
    void selectAlleFullPostsMetJPQL() {
        initDb();
        String jpdql = "SELECT fp FROM FullPost fp";
        TypedQuery<FullPost> jpqlQuery = em.createQuery(jpdql, FullPost.class);
        List<FullPost> fullPosts = jpqlQuery.getResultList();
        for (FullPost fp: fullPosts){
            System.out.println(fp);
        }
    }

    @Test
    void selectTitleVanAlleFullPostsMetJPQL() {
        initDb();
        String jpdql = "SELECT fp.title FROM FullPost fp";
        TypedQuery<String> jpqlQuery = em.createQuery(jpdql, String.class);
        List<String> titles = jpqlQuery.getResultList();
        for (String title: titles){
            System.out.println(title);
        }
    }

    @Test
    void selectTitleVanFullPostsMetIdIs1MetJPQL() {
        initDb();
        String jpdql = "SELECT fp.title FROM FullPost fp WHERE fp.id=1";
        TypedQuery<String> jpqlQuery = em.createQuery(jpdql, String.class);
        List<String> titles = jpqlQuery.getResultList();
        for (String title: titles){
            System.out.println(title);
        }
    }

    @Test
    void selectNameCategoryVanFullPostsMetIdIs1MetJPQL() {
        initDb();
        String jpdql = "SELECT fp.category.name FROM FullPost fp WHERE fp.id=1";
        TypedQuery<String> jpqlQuery = em.createQuery(jpdql, String.class);
        List<String> namen = jpqlQuery.getResultList();
        for (String naam: namen){
            System.out.println(naam);
        }
    }
    private void initDb() {
        em.getTransaction().begin();

        Category lunch = new Category("Lunch");
        em.persist(lunch);
        em.persist(new FullPost(1,"Smullen met pannekoeken", lunch));
        Category vega = new Category("Vega");
        em.persist(vega);
        em.persist(new FullPost(2,"Smullen met lasanga", vega));
        Category snack = new Category("Snack");
        em.persist(snack);
        em.persist(new FullPost(3,"Smullen met worstenbroodje", snack));
        em.getTransaction().commit();
        em.close();
        em = emf.createEntityManager();
    }



}
