package com.example.infnetjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="medico_id")
    Medico medico;

    @ManyToOne
    @JoinColumn(name="paciente_id")
    Paciente paciente;

    @NotNull
    LocalDateTime dataHora;

    public Atendimento() {
    }

    public Atendimento(Long id, Medico medico, Paciente paciente, LocalDateTime dataHora) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
    }

    public Atendimento(Medico medico, Paciente paciente, LocalDateTime dataHora) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", dataHora=" + dataHora +
                '}';
    }
}
