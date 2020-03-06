package br.com.caelum.financas.modelos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Movimentacao extends EntidadeBase {

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;

    private BigDecimal valor;
    private String descricao;

    @ManyToOne
    private Conta conta;

    @ManyToMany
    private List<Categoria> categorias = new ArrayList<>();

    public Movimentacao() {
    }

    public Movimentacao(TipoMovimentacao tipo, Calendar data, BigDecimal valor, String descricao, Conta conta, List<Categoria> categoria) {
        super();
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.conta = conta;
        this.categorias = categoria;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "\nMovimentacao:" +
                "\nTipo: " + tipo.getDescricao() +
                "\ndata: " + data.getTime() +
                "\nValor: " + valor +
                "\nDescricao: " + descricao +
                conta +
                "\nCategorias: " + categorias;
    }
}