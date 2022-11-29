package com.example.infnetjpa.persistencia;

import com.example.infnetjpa.model.Especialidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long> {
}
