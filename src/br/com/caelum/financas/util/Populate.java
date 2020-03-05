package br.com.caelum.financas.util;

import br.com.caelum.financas.modelos.Conta;

import javax.persistence.EntityManager;

public class Populate {

    public static void main(String[] args) {
        Conta cc1 = new Conta("Lucas Ribeiro","Banco Inter S.A","0001","123456-7");
        Conta cc2 = new Conta("Maylin Araujo","Banco Inter S.A","0001","154987-0");
        Conta cc3 = new Conta("Ana Lucia","Banco Inter S.A","0001","115984-8");
        Conta cc4 = new Conta("Thiago Goulart","Banco Inter S.A","0001","565489-9");
        Conta cc5 = new Conta("Raul Severo","Banco Inter S.A","0001","977219-7");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        entityManager.persist(cc1);
        entityManager.persist(cc2);
        entityManager.persist(cc3);
        entityManager.persist(cc4);
        entityManager.persist(cc5);
        entityManager.getTransaction().commit();

        entityManager.close();
    }


}
