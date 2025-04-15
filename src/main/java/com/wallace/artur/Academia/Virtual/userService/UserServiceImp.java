package com.wallace.artur.Academia.Virtual.userService;

import com.wallace.artur.Academia.Virtual.AcessToken;
import com.wallace.artur.Academia.Virtual.User.User;
import com.wallace.artur.Academia.Virtual.User.UserService;
import com.wallace.artur.Academia.Virtual.exception.DuplicateTupleException;
import com.wallace.artur.Academia.Virtual.jwt.JwtService;
import com.wallace.artur.Academia.Virtual.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public AcessToken authenticate(String email, String password) {
        var user = getByEmail(email);
        if(user == null ) {
            return null;
        }

        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if (matches) {
            return jwtService.generateToken(user);
        }
        return null;
    }

    @Override
    @Transactional
    public User save(User user) {
        var possibleUser = getByEmail(user.getEmail());
        if(possibleUser != null) {
            throw new DuplicateTupleException("User already exists");
        }
        encodePassword(user);
        return userRepository.save(user);
    }

    private void encodePassword(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword =  passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
    }
}
