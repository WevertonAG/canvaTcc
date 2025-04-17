package com.example.canvaTcc.service;

import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
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
}
