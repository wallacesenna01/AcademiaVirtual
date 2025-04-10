package com.wallace.artur.Academia.Virtual.services;

import com.wallace.artur.Academia.Virtual.domain.Professor;
import com.wallace.artur.Academia.Virtual.dtos.ProfessorCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.ProfessorPublicDTO;
import com.wallace.artur.Academia.Virtual.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public ProfessorCreateDTO save(ProfessorCreateDTO dto) {
        Professor professor = new Professor();

        professor.setName(dto.name());
        professor.setEmail(dto.email());
        professor.setPhone(dto.phone());
        professor.setSpeciality(dto.speciality());
        professor.setHireDate(LocalDate.now());

        Professor professorSaved = professorRepository.save(professor);

        return new ProfessorCreateDTO(professorSaved.getName(), professorSaved.getEmail(), professorSaved.getPhone(),
                professorSaved.getSpeciality(),professorSaved.getHireDate()
                );
    }

    public List<ProfessorPublicDTO> listar() {
        return professorRepository.findAll().stream()
                .map( professor -> new ProfessorPublicDTO(
                        professor.getName(),professor.getSpeciality()
                )).toList();
    }

}
