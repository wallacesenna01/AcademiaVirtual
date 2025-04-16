package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.domain.UserSimple;
import com.wallace.artur.Academia.Virtual.dtos.UserSimpleDTO;
import com.wallace.artur.Academia.Virtual.repositories.UserSimpleRepository;
import com.wallace.artur.Academia.Virtual.services.UserSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserSimpleController {

    private final UserSimpleService userSimpleService;

    @Autowired
    private UserSimpleRepository userSimpleRepository;

    public UserSimpleController(UserSimpleService userSimpleService) {
        this.userSimpleService = userSimpleService;
    }

    @PostMapping
    public ResponseEntity<UserSimpleDTO> save (@RequestBody UserSimpleDTO dto) {
        UserSimpleDTO userSimpleDTO = userSimpleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserSimpleDTO login) {
        boolean autenticado = userSimpleService.validarLogin(login.name(), login.password());
        if (autenticado) {
            return ResponseEntity.ok("Login aceito !");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

}
