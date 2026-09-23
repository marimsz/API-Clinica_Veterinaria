package com.aluno.senai.clinica_veterinaria.repository;

import com.aluno.senai.clinica_veterinaria.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
