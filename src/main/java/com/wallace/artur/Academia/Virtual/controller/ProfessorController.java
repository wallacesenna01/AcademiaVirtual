package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.dtos.ProfessorCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.ProfessorPublicDTO;
import com.wallace.artur.Academia.Virtual.services.ProfessorService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@CrossOrigin("*")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorCreateDTO> save(@RequestBody ProfessorCreateDTO professorCreateDTO) {
        ProfessorCreateDTO professorSaved = professorService.save(professorCreateDTO);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProfessorPublicDTO>> list() {
        List<ProfessorPublicDTO> professor = professorService.listar();
         return ResponseEntity.ok(professor);
    }
}
