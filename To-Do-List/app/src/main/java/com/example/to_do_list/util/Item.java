package com.example.to_do_list.util;

import java.io.Serializable;

public class Item implements Serializable {
    private String nome;
    private String descricao;
    private int prioridade;

    public Item(String nome, String desc, int prio){
        this.nome = nome;
        this.descricao = desc;
        this.prioridade = prio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
