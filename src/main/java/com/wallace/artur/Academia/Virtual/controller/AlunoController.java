package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.dtos.AlunoCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.AlunoDTO;
import com.wallace.artur.Academia.Virtual.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<AlunoCreateDTO> salvarAluno(@RequestBody AlunoCreateDTO dto) {
        AlunoCreateDTO alunoSalvo = alunoService.criarAluno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll(AlunoDTO dto) {
        List<AlunoDTO> alunos = alunoService.listar(dto);
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Object>> deletar(@PathVariable Long id) {

        alunoService.deletar(id);

        Map<String, Object> alunodelet = new HashMap<>();
        alunodelet.put("Message ", "Aluno deletado com sucesso" );
        alunodelet.put("id", id);
        alunodelet.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(alunodelet);
    }
}
