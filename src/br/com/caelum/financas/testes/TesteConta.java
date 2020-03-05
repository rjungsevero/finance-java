package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelos.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {

    public static void main(String[] args) {

        Conta cc1 = new Conta("Raul Severo","Banco Inter S.A","0001","977219-7");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(cc1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
