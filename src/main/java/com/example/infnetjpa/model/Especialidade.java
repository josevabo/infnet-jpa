package com.example.infnetjpa.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Especialidade {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codigo;
    @NotNull
    private String nome;

    public Especialidade() {
    }

    public Especialidade(Long codigo) {
        this.codigo = codigo;
    }

    public Especialidade(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
