package com.wallace.artur.Academia.Virtual.repositories;

import com.wallace.artur.Academia.Virtual.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
