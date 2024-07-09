package com.hipizza.demo.modules.estabelecimento.controller;

import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;
import com.hipizza.demo.modules.estabelecimento.service.EstabelecimentoService;
import com.hipizza.demo.modules.login.dto.CreateEstabelecimentoDTO;
import com.hipizza.demo.modules.roles.repository.RoleRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarEstabelecimento extends BaseEstabelecimentoController{

    private final EstabelecimentoRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    public CriarEstabelecimento(EstabelecimentoRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Operation(summary = "Cadastrar um estabelecimento")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> newEstabelecimento(@RequestBody CreateEstabelecimentoDTO estabelecimentoDTO) {
        estabelecimentoService.cadastrarEstabelecimento(estabelecimentoDTO);

        return ResponseEntity.ok().body("Estabelecimento cadastrado com sucesso.");
    }

}
