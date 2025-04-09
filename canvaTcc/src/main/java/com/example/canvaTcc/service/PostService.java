package com.example.canvaTcc.service;

import com.example.canvaTcc.model.entity.Post;

import com.example.canvaTcc.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Post findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        Post post = repository.findById(id).orElse(null);
        repository.deleteById(id);
    }
}
