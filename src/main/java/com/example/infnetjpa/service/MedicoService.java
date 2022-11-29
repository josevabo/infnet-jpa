package com.example.infnetjpa.service;

import com.example.infnetjpa.model.Medico;
import com.example.infnetjpa.persistencia.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }


    public List<Medico> listarTodos() {
        var medicos = (List<Medico>) medicoRepository.findAll();

        return medicos;
    }

    public Medico obter(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizar(Long id, Medico medico) {
        var medicoDB = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        medicoDB.setNome(medico.getNome());
        medicoDB.setEspecialidade(medico.getEspecialidade());
        medicoDB.setCrm(medico.getCrm());

        return medicoRepository.save(medicoDB);
    }

    public void deletar(Long id) throws Exception {
        var medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        try {
            medicoRepository.delete(medico);
        } catch (Exception e) {
            throw new Exception("Falha ao excluir médico!");
        }

    }

}
