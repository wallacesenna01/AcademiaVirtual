package com.wallace.artur.Academia.Virtual.repositories;

import com.wallace.artur.Academia.Virtual.domain.UserSimple;
import com.wallace.artur.Academia.Virtual.dtos.UserSimpleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSimpleRepository extends JpaRepository<UserSimple, Long> {

     List<UserSimple> findByNameAndPassword(String name, String password); ;

}
