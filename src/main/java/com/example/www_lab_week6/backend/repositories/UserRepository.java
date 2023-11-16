package com.example.www_lab_week6.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.www_lab_week6.backend.models.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);
}