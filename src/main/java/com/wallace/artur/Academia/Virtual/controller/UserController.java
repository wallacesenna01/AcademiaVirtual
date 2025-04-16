package com.wallace.artur.Academia.Virtual.controller;

import com.wallace.artur.Academia.Virtual.User.User;
import com.wallace.artur.Academia.Virtual.User.UserService;
import com.wallace.artur.Academia.Virtual.dtos.CredentialsDTO;
import com.wallace.artur.Academia.Virtual.dtos.UserDTO;
import com.wallace.artur.Academia.Virtual.dtos.UserMapper;
import com.wallace.artur.Academia.Virtual.exception.DuplicateTupleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserMapper userMapper;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDTO dto) {
        try {
            User user = userMapper.mapToUser(dto);
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (DuplicateTupleException e) {
            Map<String, String> jssonResult = Map.of("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jssonResult);
        }
    }

    @PostMapping("/auth")
     public ResponseEntity authenticate(@RequestBody CredentialsDTO credentialsDTO) {
        var token = userService.authenticate(credentialsDTO.email(), credentialsDTO.password());
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(token);
     }
}
