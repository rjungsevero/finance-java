package br.com.caelum.financas.util;

import br.com.caelum.financas.modelos.Conta;

import javax.persistence.EntityManager;

public class Populate {

    public static void main(String[] args) {
        Conta cc2 = new Conta("Banco Inter S.A","0001","154987-0");
        Conta cc1 = new Conta("Banco Inter S.A","0001","123456-7");
        Conta cc3 = new Conta("Banco Inter S.A","0001","115984-8");
        Conta cc4 = new Conta("Banco Inter S.A","0001","565489-9");
        Conta cc5 = new Conta("Banco Inter S.A","0001","977219-7");

        EntityManager entityManagerPopulate = JPAUtil.getEntityManagerFactory();

        entityManagerPopulate.getTransaction().begin();

        entityManagerPopulate.persist(cc1);
        entityManagerPopulate.persist(cc2);
        entityManagerPopulate.persist(cc3);
        entityManagerPopulate.persist(cc4);
        entityManagerPopulate.persist(cc5);
        entityManagerPopulate.getTransaction().commit();

        entityManagerPopulate.close();
    }
}
