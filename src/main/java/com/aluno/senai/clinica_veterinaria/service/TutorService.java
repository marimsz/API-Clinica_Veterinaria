package com.aluno.senai.clinica_veterinaria.service;

import com.aluno.senai.clinica_veterinaria.entity.Tutor;
import com.aluno.senai.clinica_veterinaria.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    //Cadastrar Tutor
    public Tutor cadastrar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    //Listar Tutor
    public List<Tutor> listar() {
        return tutorRepository.findAll();
    }

    //Consutor Tutor por id
    public Optional<Tutor> consultarPorId(Long id) {
        return tutorRepository.findById(id);
    }

    //Modificar Tutor
    public Tutor modificar(Long id, Tutor dados) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        tutor.setNome(dados.getNome());
        tutor.setCpf(dados.getCpf());
        tutor.setTelefone(dados.getTelefone());
        tutor.setEmail(dados.getEmail());

        return tutorRepository.save(tutor);
    }

    //Excluir Tutor
    public void excluir(Long id) {
        tutorRepository.deleteById(id);
    }
}
