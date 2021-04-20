package com.lead.pizzaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;

@Entity
public class Pizza {
    @Id
    @GeneratedValue
    private int id;
    private String sabor;
    private char tamanho;

    public Pizza(int id, String sabor, char tamanho) {
        this.id = id;
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    public Pizza(String sabor, char tamanho) {
        this.sabor = sabor;
        this.tamanho = tamanho;
    }
    public Pizza() {
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public String getSabor() {
        return sabor;
    }

    public char getTamanho() {
        return tamanho;
    }

}



