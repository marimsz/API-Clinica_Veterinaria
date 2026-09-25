package com.aluno.senai.clinica_veterinaria.controller;


import com.aluno.senai.clinica_veterinaria.entity.Tutor;
import com.aluno.senai.clinica_veterinaria.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    //Cadastrar Tutor
    @PostMapping
    public Tutor cadastrar(@RequestBody Tutor tutor) {
        return tutorService.cadastrar(tutor);
    }

    //Listar Tutor
    @GetMapping
    public List<Tutor> listar() {
        return tutorService.listar();
    }

    //Consultar Tutor por Id
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> consultarPorId(@PathVariable Long id) {
        return tutorService.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Modificar Tutor
    @PutMapping("/{id}")
    public Tutor modificar(
            @PathVariable Long id,
            @RequestBody Tutor tutor) {

        return tutorService.modificar(id, tutor);
    }

    //Excluir Tutor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tutorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
