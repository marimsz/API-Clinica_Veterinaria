package com.aluno.senai.clinica_veterinaria.service;

import com.aluno.senai.clinica_veterinaria.entity.Clinica;
import com.aluno.senai.clinica_veterinaria.entity.Veterinario;
import com.aluno.senai.clinica_veterinaria.repository.ClinicaRepository;
import com.aluno.senai.clinica_veterinaria.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final ClinicaRepository clinicaRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository,
    ClinicaRepository clinicaRepository) {
        this.veterinarioRepository = veterinarioRepository;
        this.clinicaRepository = clinicaRepository;
    }

    //Cadastrar Veterinario
    public Veterinario cadastrar(Veterinario veterinario) {

        if (veterinario.getClinica() == null ||
             veterinario.getClinica().getId() == null) {
            throw new RuntimeException("Selecione uma clínica");
        }

        Long clinicaId = veterinario.getClinica().getId();

        Clinica clinica = clinicaRepository.findById(clinicaId)
                .orElseThrow(() ->
                        new RuntimeException("Clínica não encontrada"));

        veterinario.setClinica(clinica);

        return veterinarioRepository.save(veterinario);
    }

    //Listar Veterinario
    public List<Veterinario> listar() {
        return veterinarioRepository.findAll();
    }

    //Consultar Veterinario por Id
    public Optional<Veterinario> consultarPorId(Long id) {
        return veterinarioRepository.findById(id);
    }

    //Modificar Vaterinario
    public Veterinario modificar (Long id, Veterinario dados) {

        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        veterinario.setNome(dados.getNome());
        veterinario.setTelefone(dados.getTelefone());
        veterinario.setEmail(dados.getEmail());

        if (dados.getClinica() != null &&
                dados.getClinica().getId() != null) {

            Long clinicaId = dados.getClinica().getId();

            Clinica clinica = clinicaRepository.findById(clinicaId)
                    .orElseThrow(() ->
                            new RuntimeException("Clínica não encontrada"));

            veterinario.setClinica(clinica);
        }

        return veterinarioRepository.save(veterinario);
    }

    //Excluir Veterinario
    public void excluir(Long id) {
        veterinarioRepository.deleteById(id);
    }
}
