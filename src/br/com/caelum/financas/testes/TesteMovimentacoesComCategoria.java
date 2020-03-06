package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelos.*;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class TesteMovimentacoesComCategoria {

    public static void main(String[] args) {

        Categoria viagem = new Categoria("Viagem");
        Categoria negocios = new Categoria("Negócios");

        Conta conta = new Conta("Banco Inter S.A", "0001", "977219-7");

        Cliente cliente = new Cliente(
                "Raul Severo",
                "Desenvolvedor",
                "Avenida Bento Gonçalves, 717/Apto 1 - Partenon, Porto Alegre RS",
                conta);

        Cliente cliente2 = new Cliente(
                "Maylin Araújo",
                "Advogada",
                "Avenida Bento Gonçalves, 717/Apto 1 - Partenon, Porto Alegre RS",
                conta);


        Movimentacao movimentacaoSP = new Movimentacao(
                TipoMovimentacao.SAIDA,
                Calendar.getInstance(),
                new BigDecimal("470.00"),
                "Viagem à São Paulo", conta, Arrays.asList(viagem, negocios));

        Movimentacao movimentacaoRJ = new Movimentacao(
                TipoMovimentacao.SAIDA,
                Calendar.getInstance(),
                new BigDecimal("970.00"),
                "Viagem à Rio de Janeiro", conta, Collections.singletonList(viagem));

        EntityManager entityManager = JPAUtil.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        entityManager.persist(viagem);
        entityManager.persist(negocios);
        entityManager.persist(conta);
        entityManager.persist(cliente);
        entityManager.persist(movimentacaoSP);
        entityManager.persist(movimentacaoRJ);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pCategoria", negocios);

        List<Movimentacao> movimentacoes = query.getResultList();

        movimentacoes.forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
