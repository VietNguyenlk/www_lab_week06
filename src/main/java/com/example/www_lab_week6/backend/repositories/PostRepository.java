package com.example.www_lab_week6.backend.repositories;

import com.example.www_lab_week6.backend.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.www_lab_week6.backend.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByAuthor(User user, Pageable pageable);
}