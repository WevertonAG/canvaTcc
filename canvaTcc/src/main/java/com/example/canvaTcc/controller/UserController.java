package com.example.canvaTcc.controller;

import com.example.canvaTcc.model.DTO.PostResumeDTO;
import com.example.canvaTcc.model.DTO.UserDTO;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.findAll().stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getLogin(),
                        user.getPosts().stream()
                                .map(post -> new PostResumeDTO(
                                        post.getId(),
                                        post.getDescription(),
                                        post.getCategory()
                                ))
                                .toList()
                )).toList();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) {
        User user = service.findById(id);
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPosts().stream()
                        .map(post -> new PostResumeDTO(
                                post.getId(),
                                post.getDescription(),
                                post.getCategory()
                        ))
                        .toList()
        );

        return ResponseEntity.ok(userDTO);
    }
}
