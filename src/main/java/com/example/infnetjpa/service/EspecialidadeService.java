package com.example.infnetjpa.service;

import com.example.infnetjpa.model.Especialidade;
import com.example.infnetjpa.persistencia.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    public List<Especialidade> listarTodos() {
        var medicos = (List<Especialidade>) repository.findAll();

        return medicos;
    }

    public Especialidade obter(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
    }

    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    public Especialidade atualizar(Long id, Especialidade especialidade) {
        var especialidadeDB = repository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));

        especialidadeDB.setNome(especialidade.getNome());

        return repository.save(especialidadeDB);
    }

    public void deletar(Long id) throws Exception {
        var especialidade = repository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrado"));

        try {
            repository.delete(especialidade);
        } catch (Exception e) {
            throw new Exception("Falha ao excluir especialidade!");
        }

    }

}
