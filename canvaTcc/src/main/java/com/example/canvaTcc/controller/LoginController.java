package com.example.canvaTcc.controller;

import com.example.canvaTcc.model.DTO.LoginDTO;
import com.example.canvaTcc.model.DTO.LoginResponseDTO;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.service.LoginService;
import com.example.canvaTcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try{
            User user = loginService.authenticate(
                    loginDTO.getId(),
                    loginDTO.getLogin(),
                    loginDTO.getPassword(),
                    loginDTO.getName()
            );
            LoginResponseDTO response = new LoginResponseDTO(user.getId(),user.getName());
            return ResponseEntity.ok(response);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}