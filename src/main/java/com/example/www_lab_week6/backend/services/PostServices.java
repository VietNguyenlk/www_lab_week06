package com.example.www_lab_week6.backend.services;

import com.example.www_lab_week6.backend.models.Post;
import com.example.www_lab_week6.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.www_lab_week6.backend.repositories.PostRepository;

import java.util.Optional;

@Service
@NoArgsConstructor @AllArgsConstructor
public class PostServices {
    @Autowired
    private PostRepository postRepository;

    public Optional<Post> findByID(long id){return  postRepository.findById(id);}
    public Page<Post> findAll(int page, int size, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return postRepository.findAll(pageable);
    }
    public  Page<Post> findByAuthor(User user, int page, int size, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(page-1,size,sort);
        return postRepository.findByAuthor(user,pageable);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }


}