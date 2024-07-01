package com.hipizza.demo.modules.login.controller;

import com.hipizza.demo.modules.login.service.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;
import com.hipizza.demo.modules.login.dto.LoginRequest;
import com.hipizza.demo.modules.login.dto.LoginResponse;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;

import java.time.Instant;

@CrossOrigin("https://anton3496.c35.integrator.host")
@RestController
@RequestMapping("/login")
public class TokenController {

    @Autowired
    public LoginService loginService;

    @PostMapping("/auth/estabelecimento")
    public ResponseEntity<LoginResponse> authEstab(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = loginService.authenticateEstabelecimento(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/cliente")
    public ResponseEntity<?> authCliente(@RequestBody LoginRequest loginRequest){
        LoginResponse response = loginService.authenticateCliente(loginRequest);
        return ResponseEntity.ok(response);
    }
}
