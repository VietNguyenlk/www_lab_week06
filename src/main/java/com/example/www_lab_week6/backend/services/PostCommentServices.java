package com.example.www_lab_week6.backend.services;



import com.example.www_lab_week6.backend.models.PostComment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.www_lab_week6.backend.repositories.PostCommentRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentServices {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public PostComment save(PostComment postComment) {
        return postCommentRepository.save(postComment);
    }
}