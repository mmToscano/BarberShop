package com.example.barberapplication.model;

public class Servicos {

    private Integer img = null;
    private String nome = null;

    public Servicos(Integer img, String nome) {
        this.img = img;
        this.nome = nome;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
