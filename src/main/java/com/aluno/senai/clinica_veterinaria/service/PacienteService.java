package com.aluno.senai.clinica_veterinaria.service;


import com.aluno.senai.clinica_veterinaria.entity.Paciente;
import com.aluno.senai.clinica_veterinaria.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //Cadastrar Pacientes
    public Paciente cadastrar(Paciente paciente) {
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

        return pacienteRepository.save(paciente);
    }

    //Excluir Paciente
    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }
}
