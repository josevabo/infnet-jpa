package com.example.infnetjpa.persistencia;

import com.example.infnetjpa.model.Atendimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long> {
}
