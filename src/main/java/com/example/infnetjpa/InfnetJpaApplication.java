package com.example.infnetjpa;

import com.example.infnetjpa.model.Atendimento;
import com.example.infnetjpa.model.Especialidade;
import com.example.infnetjpa.model.Medico;
import com.example.infnetjpa.model.Paciente;
import com.example.infnetjpa.service.AtendimentoService;
import com.example.infnetjpa.service.EspecialidadeService;
import com.example.infnetjpa.service.MedicoService;
import com.example.infnetjpa.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class InfnetJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(InfnetJpaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(InfnetJpaApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(MedicoService medicoService,
                                  EspecialidadeService especialidadeService,
                                  PacienteService pacienteService,
                                  AtendimentoService atendimentoService) {
        return (args) -> {
            // criar algumas especialidades
            log.info("Criando especialidades:");
            log.info("-------------------------------");
            especialidadeService.salvar(new Especialidade("Oftalmologista"));
            especialidadeService.salvar(new Especialidade("Cardiologista"));
            List<Especialidade> especialidades = especialidadeService.listarTodos();

            // criar alguns médicos
            log.info("Criando médicos:");
            log.info("-------------------------------");
            medicoService.salvar(new Medico("novo medico 1", "12345RJ", especialidades.get(0)));
            medicoService.salvar(new Medico("novo medico 2", "12345RJ", especialidades.get(1)));
            medicoService.salvar(new Medico("novo medico 3", "12345RJ", especialidades.get(0)));
            medicoService.salvar(new Medico("novo medico 4", "12345RJ", especialidades.get(1)));

            log.info("Médicos existentes na base:");
            log.info("-------------------------------");
            List<Medico> medicos = medicoService.listarTodos();
            for (Medico medico : medicos) {
                log.info(medico.toString());
            }
            log.info("");

            Medico medico = medicoService.obter(1L);
            log.info("Medico de ID 1:");
            log.info("--------------------------------");
            log.info(medico.toString());
            log.info("");

            // criar alguns médicos
            log.info("Criando pacientes:");
            log.info("-------------------------------");
            pacienteService.salvar(new Paciente("Maria", "12345678900", LocalDate.of(2000,01,01)));
            pacienteService.salvar(new Paciente("José", "999999999999", LocalDate.of(1990,01,01)));
            pacienteService.salvar(new Paciente("João", "111111111111", LocalDate.of(1980,01,01)));

            log.info("Listando todos pacientes:");
            log.info("-------------------------------");
            var pacientes = pacienteService.listarTodos();
            for (Paciente paciente : pacientes) {
                log.info(paciente.toString());
            }

            //criar alguns atendimentos
            log.info("Criando atendimentos:");
            log.info("-------------------------------");
            atendimentoService.salvar(new Atendimento(null, medicos.get(0), pacientes.get(0), LocalDateTime.of(2022,11,1,12,0)));
            atendimentoService.salvar(new Atendimento(null, medicos.get(1), pacientes.get(1), LocalDateTime.of(2022,11,2,12,0)));
            atendimentoService.salvar(new Atendimento(null, medicos.get(2), pacientes.get(2), LocalDateTime.of(2022,11,3,12,0)));

            log.info("Listando atendimentos:");
            log.info("-------------------------------");
            for (Atendimento atendimento : atendimentoService.listarTodos()){
                log.info(atendimento.toString());
            }
        };

    }
}

