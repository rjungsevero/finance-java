package br.com.caelum.financas.modelos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends EntidadeBase {

    private String nome;
    private String profissao;
    private String endereco;

    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;

    public Cliente() {
    }

    public Cliente(String nome, String profissao, String endereco, Conta conta) {
        super();
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\nNome: " + nome + '\'' +
                "\nProfissao:" + profissao + '\'' +
                "\nEndereco:" + endereco + '\'' +
                "\n" + conta;
    }
}
