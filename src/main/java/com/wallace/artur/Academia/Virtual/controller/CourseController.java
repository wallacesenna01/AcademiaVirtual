package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.dtos.CourseDTO;
import com.wallace.artur.Academia.Virtual.dtos.CourseUpdateDTO;
import com.wallace.artur.Academia.Virtual.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseUpdateDTO>> listar(){
       List<CourseUpdateDTO> cursos = courseService.listar();
       return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody @Valid CourseDTO dto) {
        CourseDTO savedCurso = courseService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseUpdateDTO> update(@RequestBody CourseUpdateDTO dto, @PathVariable Long id) {
        CourseUpdateDTO courseUpdateDTO = courseService.update(dto,id);
        return ResponseEntity.ok(courseUpdateDTO);
    }

    @DeleteMapping("/{id}")
   public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        courseService.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Curso deletado com sucesso");
        response.put("id", id);
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}
