package com.wallace.artur.Academia.Virtual.services;

import com.wallace.artur.Academia.Virtual.domain.Aluno;
import com.wallace.artur.Academia.Virtual.domain.Course;
import com.wallace.artur.Academia.Virtual.domain.Matricula;
import com.wallace.artur.Academia.Virtual.domain.Professor;
import com.wallace.artur.Academia.Virtual.dtos.MatriculaCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.MatriculaDTO;
import com.wallace.artur.Academia.Virtual.repositories.AlunoRepository;
import com.wallace.artur.Academia.Virtual.repositories.CourseRepository;
import com.wallace.artur.Academia.Virtual.repositories.MatriculaRepository;
import com.wallace.artur.Academia.Virtual.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatriculaService {

         @Autowired
         private AlunoRepository alunoRepository;

         @Autowired
         private CourseRepository courseRepository;

         @Autowired
         private MatriculaRepository matriculaRepository;

     public MatriculaDTO save(MatriculaCreateDTO dto){

         Aluno aluno = alunoRepository.findById(dto.alunoId())
                 .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado " + dto.alunoId()));

         Course course = courseRepository.findById(dto.cursoId())
                 .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

         Matricula matricula = new Matricula();

         matricula.setAluno(aluno);
         matricula.setCurso(course);
         matricula.setDataMatricula(LocalDateTime.now());
         matricula.setActivo(true);

         Matricula saved = matriculaRepository.save(matricula);

         return new MatriculaDTO(saved.getId(), aluno.getId(), aluno.getName(), course.getId(), course.getName(), saved.getDataMatricula());
     }

     public List<MatriculaDTO> listar() {
         List<Matricula> matriculas = matriculaRepository.findAll();

              return  matriculas.stream().map(matricula -> new MatriculaDTO(
                         matricula.getId(), matricula.getAluno().getId(), matricula.getAluno().getName(), matricula.getCurso().getId(),
                         matricula.getCurso().getName(),
                         matricula.getDataMatricula()
                 )).toList();
     }
}
