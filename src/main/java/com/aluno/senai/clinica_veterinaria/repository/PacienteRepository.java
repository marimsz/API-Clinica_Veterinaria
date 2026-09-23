package com.aluno.senai.clinica_veterinaria.repository;

import com.aluno.senai.clinica_veterinaria.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
