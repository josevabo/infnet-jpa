package com.example.infnetjpa.service;

import com.example.infnetjpa.model.Atendimento;
import com.example.infnetjpa.persistencia.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }


    public List<Atendimento> listarTodos() {
        var atendimentos = (List<Atendimento>) atendimentoRepository.findAll();

        return atendimentos;
    }

    public Atendimento obter(Long id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento atualizar(Long id, Atendimento atendimento) {
        var atendimentoDB = atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        atendimentoDB.setDataHora(atendimento.getDataHora());
        atendimentoDB.setMedico(atendimento.getMedico());
        atendimentoDB.setPaciente(atendimento.getPaciente());

        return atendimentoRepository.save(atendimentoDB);
    }

    public void deletar(Long id) throws Exception {
        var atendimento = atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        try {
            atendimentoRepository.delete(atendimento);
        } catch (Exception e) {
            throw new Exception("Falha ao excluir Atendimento!");
        }

    }

}
