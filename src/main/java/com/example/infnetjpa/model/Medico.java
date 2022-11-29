package com.example.infnetjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    private String crm;

    @ManyToOne
    @NotNull
    @JoinColumn(name="especialidade_id")
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(String nome, String crm, Especialidade especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico(String nome) {
        super();
        this.nome = nome;
    }

    public Medico(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public Medico(Long id, String nome, String crm) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
    }

    public Medico(Long id, String nome, String crm, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome =nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Médico [codigo=" + id + ", nome=" + nome + ", CRM=" + crm + ", Especialidade=" + especialidade + "]";
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}
