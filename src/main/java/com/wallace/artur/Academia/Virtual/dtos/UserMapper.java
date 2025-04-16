package com.wallace.artur.Academia.Virtual.dtos;


import com.wallace.artur.Academia.Virtual.User.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public  User mapToUser(UserDTO dto) {
        return new User(dto.name(), dto.email(), dto.password());
    }
    public  UserDTO mapToUser(User user) {
        return new UserDTO(user.getName(),user.getEmail(), user.getPassword());
    }
}
