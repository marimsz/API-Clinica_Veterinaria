package com.aluno.senai.clinica_veterinaria.service;

import com.aluno.senai.clinica_veterinaria.entity.Veterinario;
import com.aluno.senai.clinica_veterinaria.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    //Cadastrar Veterinario
    public Veterinario cadastrar(Veterinario veterinario) {
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

        return veterinarioRepository.save(veterinario);
    }

    //Excluir Veterinario
    public void excluir(Long id) {
        veterinarioRepository.deleteById(id);
    }
}
