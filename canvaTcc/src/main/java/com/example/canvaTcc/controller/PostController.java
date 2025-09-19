package com.example.canvaTcc.controller;

import com.example.canvaTcc.model.DTO.PostDTO;
import com.example.canvaTcc.model.DTO.PostRequestDTO;
import com.example.canvaTcc.model.DTO.PostResponseDTO;
import com.example.canvaTcc.model.entity.Post;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.service.PostService;
import com.example.canvaTcc.service.UserService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                post.getQuadro().getId()
        )).toList();
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostRequestDTO dto) {
        PostResponseDTO created = postService.createPost(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping("/quadro/{quadroId}")
    public ResponseEntity<List<PostResponseDTO>> getPostsByQuadro(@PathVariable Integer quadroId) {
        List<PostResponseDTO> posts = postService.getPostsByQuadroId(quadroId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Integer id) {
        PostDTO dto = postService.findById(id);
        if(dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }
}
