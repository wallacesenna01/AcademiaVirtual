package com.wallace.artur.Academia.Virtual.services;

import com.wallace.artur.Academia.Virtual.domain.Aluno;
import com.wallace.artur.Academia.Virtual.dtos.AlunoCreateDTO;
import com.wallace.artur.Academia.Virtual.dtos.AlunoDTO;
import com.wallace.artur.Academia.Virtual.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoCreateDTO criarAluno(AlunoCreateDTO dto) {
        Aluno aluno = new Aluno();

        aluno.setName(dto.name());
        aluno.setEmail(dto.email());
        aluno.setCpf(dto.cpf());
        aluno.setBirthday(dto.birthday());
        aluno.setPhone(dto.phone());
        aluno.setDataRegistro(LocalDateTime.now());
        aluno.setActive(true);

      Aluno saved =  alunoRepository.save(aluno);

        return new AlunoCreateDTO(
                saved.getName(),
                saved.getEmail(),
                saved.getCpf(),
                saved.getBirthday(),
                saved.getPhone()
        );
    }

    public List<AlunoDTO> listar(AlunoDTO alunoDTO) {
     return  alunoRepository.findAll().stream().map(
                aluno -> new AlunoDTO(
                        aluno.getId(),
                        aluno.getName(),
                        aluno.getEmail(),
                        aluno.getCpf(),
                        aluno.getBirthday(),
                        aluno.getPhone(),
                        aluno.getDataRegistro(),
                        aluno.isActive()
                )).toList();
    }


    public void deletar(Long id) {
     Aluno aluno =  alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with " + id + "not found" ));

      alunoRepository.delete(aluno);
    }

}
