package com.aluno.senai.clinica_veterinaria.controller;

import com.aluno.senai.clinica_veterinaria.entity.Clinica;
import com.aluno.senai.clinica_veterinaria.service.ClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @PostMapping
    public Clinica cadastrar(@RequestBody Clinica clinica) {
        return clinicaService.cadastrar(clinica);
    }

    @GetMapping
    public List<Clinica> listar() {
        return clinicaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinica> consultarPorId(@PathVariable Long id) {
        return clinicaService.consutarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Clinica modificar(
            @PathVariable Long id,
            @RequestBody Clinica clinica) {

        return clinicaService.modificar(id, clinica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clinicaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
