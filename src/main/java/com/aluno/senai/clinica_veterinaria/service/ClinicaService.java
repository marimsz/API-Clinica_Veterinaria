package com.aluno.senai.clinica_veterinaria.service;

import com.aluno.senai.clinica_veterinaria.entity.Clinica;
import com.aluno.senai.clinica_veterinaria.repository.ClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    private final ClinicaRepository clinicaRepository;

    public ClinicaService(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    public Clinica cadastrar(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public List<Clinica> listar() {
        return clinicaRepository.findAll();
    }

    public Optional<Clinica> consutarPorId(Long id) {
        return clinicaRepository.findById(id);
    }

    public Clinica modificar(Long id, Clinica dados) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada"));

        clinica.setNome(dados.getNome());
        clinica.setCnpj(dados.getCnpj());
        clinica.setTelefone(dados.getTelefone());
        clinica.setEmail(dados.getEmail());
        clinica.setEndereco(dados.getEndereco());

        return clinicaRepository.save(clinica);
    }

    public void excluir(Long id) {
        clinicaRepository.deleteById(id);
    }
}
