package com.example.canvaTcc.service;

import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public User authenticate(Integer id, String login, String password) {
        Optional<User> user = loginRepository.findByLogin(login);
        if(user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        User pass = user.get();
        if(!pass.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        return pass;
    }
}
