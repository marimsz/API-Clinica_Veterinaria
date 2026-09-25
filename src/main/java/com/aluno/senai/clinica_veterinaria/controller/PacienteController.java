package com.aluno.senai.clinica_veterinaria.controller;


import com.aluno.senai.clinica_veterinaria.entity.Paciente;
import com.aluno.senai.clinica_veterinaria.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Cadastrar Pacientes
    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return pacienteService.cadastrar(paciente);
    }

    //Listar Pacientes
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    //Consultar Pacientes
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> consultarPorId(@PathVariable Long id) {
        return pacienteService.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Modificar Pacientes
    @PutMapping("/{id}")
    public Paciente modificar(
            @PathVariable Long id,
            @RequestBody Paciente paciente) {

        return pacienteService.modificar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pacienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
