package com.example.infnetjpa.service;

import com.example.infnetjpa.model.Paciente;
import com.example.infnetjpa.persistencia.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    public List<Paciente> listarTodos() {
        var pacientes = (List<Paciente>) pacienteRepository.findAll();

        return pacientes;
    }

    public Paciente obter(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        var pacienteDB = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteDB.setNome(paciente.getNome());
        pacienteDB.setCpf(paciente.getCpf());
        pacienteDB.setDataNasc(paciente.getDataNasc());

        return pacienteRepository.save(pacienteDB);
    }

    public void deletar(Long id) throws Exception {
        var paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        try {
            pacienteRepository.delete(paciente);
        } catch (Exception e) {
            throw new Exception("Falha ao excluir Paciente!");
        }

    }

}
