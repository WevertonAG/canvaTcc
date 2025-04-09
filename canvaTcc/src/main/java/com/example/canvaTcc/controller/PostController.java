package com.example.canvaTcc.controller;

import com.example.canvaTcc.model.DTO.PostDTO;
import com.example.canvaTcc.model.entity.Post;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.service.PostService;
import com.example.canvaTcc.service.UserService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public List<PostDTO> getAll() {
        return postService.findAll().stream().map(post -> new PostDTO(
                post.getId(),
                post.getDescription(),
                post.getCategory(),
                post.getUser().getId()
        )).toList();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        // Valida usuário antes de salvar o post
        User user = userService.findById(post.getUser().getId());
        if (user == null) throw new RuntimeException("Usuário não encontrado");
        post.setUser(user);
        return postService.save(post);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Integer id) {
        return postService.findById(id);
    }
}
