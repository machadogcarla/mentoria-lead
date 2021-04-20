package com.lead.pizzaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private long num_pedido;
    private float valor_total;
    private int tempo_preparo;
    private boolean extrabacon;
    private boolean sem_cebola;
    private boolean borda_recheada;

    public Pedido() {
    }

    public Pedido(float valor_total, int tempo_preparo, boolean extrabacon, boolean sem_cebola, boolean borda_recheada) {
        this.valor_total = valor_total;
        this.tempo_preparo = tempo_preparo;
        this.extrabacon = extrabacon;
        this.sem_cebola = sem_cebola;
        this.borda_recheada = borda_recheada;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public void setTempo_preparo(int tempo_preparo) {
        this.tempo_preparo = tempo_preparo;
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

    public long getNum_pedido() {
        return num_pedido;
    }

    public float getValor_total() {
        return valor_total;
    }

    public int getTempo_preparo() {
        return tempo_preparo;
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
}

