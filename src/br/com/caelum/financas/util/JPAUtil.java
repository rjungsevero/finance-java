package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static void main(String[] args) {
        System.out.println("Atualizando tabelas");
    }

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");

    public static EntityManager getEntityManagerFactory() {
        return entityManagerFactory.createEntityManager();
    }
}
