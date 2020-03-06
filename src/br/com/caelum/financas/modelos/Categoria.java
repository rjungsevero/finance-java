package br.com.caelum.financas.modelos;

import javax.persistence.Entity;

@Entity
public class Categoria extends EntidadeBase {

    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "" + nome;
    }
}
