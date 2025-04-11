package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.domain.Matricula;
import com.wallace.artur.Academia.Virtual.dtos.MatriculaCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.MatriculaDTO;
import com.wallace.artur.Academia.Virtual.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

       private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<MatriculaCreateDTO> save(@RequestBody MatriculaCreateDTO  dto) {
        MatriculaDTO matriculaDTO = matriculaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() {
       List<MatriculaDTO> matriculaDTOList = matriculaService.listar();
       return ResponseEntity.ok(matriculaDTOList);
    }
}
