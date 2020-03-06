package br.com.caelum.financas.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conta extends EntidadeBase {

    private String banco;
    private String agencia;
    private String numero;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public Conta() {
    }

    public Conta(String banco, String agencia, String numero) {
        super();
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @Override
    public String toString() {
        return "\nConta:" +
                "\nBanco: " + banco +
                "\nAgência: " + agencia +
                "\nNúmero: " + numero +
                "\n" + movimentacoes;
    }
}
