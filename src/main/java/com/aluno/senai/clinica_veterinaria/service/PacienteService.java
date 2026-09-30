package com.aluno.senai.clinica_veterinaria.service;


import com.aluno.senai.clinica_veterinaria.entity.Paciente;
import com.aluno.senai.clinica_veterinaria.entity.Tutor;
import com.aluno.senai.clinica_veterinaria.repository.PacienteRepository;
import com.aluno.senai.clinica_veterinaria.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final TutorRepository tutorRepository;

    public PacienteService(PacienteRepository pacienteRepository,
            TutorRepository tutorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.tutorRepository = tutorRepository;
    }

    //Cadastrar Pacientes
    public Paciente cadastrar(Paciente paciente) {

        if (paciente.getTutor() == null ||
              paciente.getTutor().getId() == null) {
            throw new RuntimeException("Selecione um tutor");
        }

        Long tutorId = paciente.getTutor().getId();

        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() ->
                        new RuntimeException(("Tutor não encontrado")));

        paciente.setTutor(tutor);

        return pacienteRepository.save(paciente);
    }

    //Listar Pacientes
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    //Consultar por ID
    public Optional<Paciente> consultarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    //Modificar Paciente
    public Paciente modificar(Long id, Paciente dados) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setNome(dados.getNome());
        paciente.setEspecie(dados.getEspecie());
        paciente.setRaca(dados.getRaca());
        paciente.setSexo(dados.getSexo());

        if (dados.getTutor() != null &&
              dados.getTutor().getId() != null) {
            Long tutorId = dados.getTutor().getId();

            Tutor tutor = tutorRepository.findById(tutorId)
                    .orElseThrow(() ->
                            new RuntimeException("Tutor não encontrado"));

             paciente.setTutor(tutor);
        }

        return pacienteRepository.save(paciente);
    }

    //Excluir Paciente
    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }
}
