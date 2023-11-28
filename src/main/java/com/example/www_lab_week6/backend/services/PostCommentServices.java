package com.example.www_lab_week6.backend.services;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.www_lab_week6.backend.repositories.PostCommentRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentServices {
    private PostCommentRepository postCommentRepository;
}