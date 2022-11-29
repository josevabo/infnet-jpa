package com.example.infnetjpa.persistencia;

import com.example.infnetjpa.model.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {
}
