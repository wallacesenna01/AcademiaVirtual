package com.wallace.artur.Academia.Virtual.services;

import com.wallace.artur.Academia.Virtual.domain.UserSimple;
import com.wallace.artur.Academia.Virtual.dtos.UserSimpleDTO;
import com.wallace.artur.Academia.Virtual.repositories.UserSimpleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSimpleService {

    private final UserSimpleRepository userSimpleRepository;

    public UserSimpleService(UserSimpleRepository userSimpleRepository) {
        this.userSimpleRepository = userSimpleRepository;
    }

    public UserSimpleDTO save(UserSimpleDTO userSimpleDTO) {
        UserSimple userSimple = new UserSimple();
        userSimple.setName(userSimple.getName());
        userSimple.setPassword(userSimpleDTO.password());

        UserSimple saved = userSimpleRepository.save(userSimple);

        return new UserSimpleDTO(saved.getName(),saved.getPassword());
    }

    public boolean validarLogin(String name, String password){
        List<UserSimple> users = userSimpleRepository.findByNameAndPassword(name,password);
        return !users.isEmpty();
    }
}
