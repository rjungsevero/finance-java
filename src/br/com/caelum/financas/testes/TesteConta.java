package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelos.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class TesteConta {

    public static void main(String[] args) {

        Conta conta = new Conta("Arthur Melo", "Banco do Brasil", "0001", "123456-7");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.getTransaction().commit();

        System.out.println(conta);
        entityManager.close();

        EntityManager entityManagerRemove = JPAUtil.getEntityManagerFactory();

        entityManagerRemove.getTransaction().begin();

        Conta contaSalva = entityManagerRemove.find(Conta.class, 22);
        entityManagerRemove.remove(contaSalva);

        entityManagerRemove.getTransaction().commit();
        entityManagerRemove.close();

    }
}
