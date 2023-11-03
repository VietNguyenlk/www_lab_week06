package com.example.www_lab_week6.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.www_lab_week6.backend.models.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}