package com.lead.pizzaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pizza {
    @Id
    @GeneratedValue
    private int id;
    private String sabor;
    private char tamanho;
    private boolean extrabacon;
    private boolean sem_cebola;
    private boolean borda_recheada;

    public Pizza() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public void setExtrabacon(boolean extrabacon) {
        this.extrabacon = extrabacon;
    }

    public void setSem_cebola(boolean sem_cebola) {
        this.sem_cebola = sem_cebola;
    }

    public void setBorda_recheada(boolean borda_recheada) {
        this.borda_recheada = borda_recheada;
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

    public boolean isExtrabacon() {
        return extrabacon;
    }

    public boolean isSem_cebola() {
        return sem_cebola;
    }

    public boolean isBorda_recheada() {
        return borda_recheada;
    }

    public Pizza(int id, String sabor, char tamanho, boolean extrabacon, boolean sem_cebola, boolean borda_recheada) {
        this.id = id;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.extrabacon = extrabacon;
        this.sem_cebola = sem_cebola;
        this.borda_recheada = borda_recheada;
    }
}
