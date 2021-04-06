package com.lead.pizzaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String cpf;
    private String nome;
    private String email;
    private String tel;

    public Client(long id, String cpf, String nome, String email, String tel) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.tel = tel;
    }

    public Client() {

    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public long getId() {
        return id;
    }

    public String getCpf() { return cpf; }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
}

