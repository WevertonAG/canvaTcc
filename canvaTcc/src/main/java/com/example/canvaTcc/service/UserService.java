package com.example.canvaTcc.service;

import com.example.canvaTcc.model.DTO.UserDTO;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserRepository userRepository;

    public UserService(UserRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        Optional<User> userOptional = repository.findByLogin(user.getLogin());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("E-mail já está em uso. Por favor, use outro.");
        }
        return repository.save(user);
    }

    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<UserDTO> searchUsers(String query) {
        List<User> users = repository.findByNameContainingIgnoreCaseOrLoginContainingIgnoreCase(query, query);
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
