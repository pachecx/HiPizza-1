package com.hipizza.demo.modules.login.service;

import com.hipizza.demo.modules.consumidor.repository.ConsumidorRepository;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;
import com.hipizza.demo.modules.login.dto.LoginRequest;
import com.hipizza.demo.modules.login.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService {

    private JwtEncoder jwtEncoder;

    private BCryptPasswordEncoder passwordEncoder;

    private ConsumidorRepository consumidorRepository;

    private EstabelecimentoRepository estabelecimentoRepository;

    public LoginService(JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder, ConsumidorRepository consumidorRepository, EstabelecimentoRepository estabelecimentoRepository) {
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
        this.consumidorRepository = consumidorRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    public LoginResponse authenticateCliente(LoginRequest loginRequest){
        var user = consumidorRepository.findByEmail(loginRequest.email());

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

        return new LoginResponse(jwtValue, expiresIn, id);
    }

    public LoginResponse authenticateEstabelecimento(LoginRequest loginRequest){
        var user = estabelecimentoRepository.findByEmail(loginRequest.email());

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

        return new LoginResponse(jwtValue, expiresIn, id);
    }
}
