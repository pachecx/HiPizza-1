package com.hipizza.demo.modules.login.controller;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hipizza.demo.modules.login.dto.LoginRequest;
import com.hipizza.demo.modules.login.dto.LoginResponse;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;

import java.time.Instant;

@CrossOrigin("https://anton3496.c35.integrator.host")
@RestController
@RequestMapping("/login")
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final EstabelecimentoRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public TokenController(JwtEncoder jwtEncoder,
            EstabelecimentoRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/logar")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        var user = userRepository.findByEmail(loginRequest.email());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("user or password is invalid!");
        }

        var userOptional = user.get();
        var id = userOptional.getId();
        var now = Instant.now();
        var expiresIn = 3000L;

        String scope = user.get().getRoles().getName();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("spring-security-jwt")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.get().getEmail())
                .claim("scope", scope)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn, id));
    }
}
