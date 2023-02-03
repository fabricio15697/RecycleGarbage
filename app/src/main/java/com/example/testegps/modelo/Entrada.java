package com.example.testegps.modelo;

public class Entrada {
    private long id;
    private String nome;
    private String email;
    private String assunto;
    private String descricao;

    public Entrada(String nome, String email, String assunto, String descricao) {
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    public Entrada(long id, String nome, String email, String assunto, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

