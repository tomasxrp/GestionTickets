package com.gestiontickets.core_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiontickets.core_api.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndDeletedAtIsNull(String email);

    List<User> findByRole(String roleName);

    
}
