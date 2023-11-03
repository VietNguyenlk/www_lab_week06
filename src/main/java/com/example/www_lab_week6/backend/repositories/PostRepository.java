package com.example.www_lab_week6.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.www_lab_week6.backend.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}