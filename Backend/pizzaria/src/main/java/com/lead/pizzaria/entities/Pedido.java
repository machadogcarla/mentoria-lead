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
    public Pedido() {
    }

    public Pedido( float valor_total, int tempo_preparo) {
        this.valor_total = valor_total;
        this.tempo_preparo = tempo_preparo;
    }

    public void setNum_pedido(long num_pedido) {
        this.num_pedido = num_pedido;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public void setTempo_preparo(int tempo_preparo) {
        this.tempo_preparo = tempo_preparo;
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


}
