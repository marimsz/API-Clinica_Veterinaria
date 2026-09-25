package com.aluno.senai.clinica_veterinaria.controller;


import com.aluno.senai.clinica_veterinaria.entity.Veterinario;
import com.aluno.senai.clinica_veterinaria.service.VeterinarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    //Cadastrar Veterinario
    @PostMapping
    public Veterinario cadastrar(@RequestBody Veterinario veterinario) {
        return veterinarioService.cadastrar(veterinario);
    }

    //Listar Veterinario
    @GetMapping
    public List<Veterinario> listar() {
        return veterinarioService.listar();
    }

    //Consultar Veterinario por Id
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> consultarPorId(@PathVariable Long id) {
        return veterinarioService.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Modificar Veterinario
    @PutMapping("/{id}")
    public Veterinario modificar(
            @PathVariable Long id,
            @RequestBody Veterinario veterinario) {

        return veterinarioService.modificar(id, veterinario);
    }

    //Excluir Veterinario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        veterinarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
