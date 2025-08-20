package com.mbonfim.forum.controllers;

import com.mbonfim.forum.infra.security.TokenResponseDTO;
import com.mbonfim.forum.models.dto.request.LoginDTO;
import com.mbonfim.forum.models.dto.request.RegisterDTO;
import com.mbonfim.forum.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Authentication {

    @Autowired
    AuthenticationService service;

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginDTO dados) {
        String token = service.login(dados, manager);
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO dados) {
        service.register(dados);
        return ResponseEntity.ok().build();
    }


}
