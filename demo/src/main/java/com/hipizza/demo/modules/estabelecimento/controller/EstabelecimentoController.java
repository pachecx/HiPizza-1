package com.hipizza.demo.modules.estabelecimento.controller;

import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;
import com.hipizza.demo.modules.estabelecimento.service.EstabelecimentoService;
import com.hipizza.demo.modules.login.dto.CreateUserDto;
import com.hipizza.demo.modules.roles.domain.Role;
import com.hipizza.demo.modules.roles.repository.RoleRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Tag(name = "Controle de estabelecimentos")

@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    // @Operation(summary = "Cadastrar um estabelecimento")
    // @PostMapping(value = "/cadastrar")
    // public ResponseEntity<String> incluir(@Validated @RequestBody Estabelecimento
    // estabelecimento) {
    // estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
    // return ResponseEntity.ok("Estabelecimento cadastrado com sucesso!");
    // }

    private final EstabelecimentoRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public EstabelecimentoController(EstabelecimentoRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Operation(summary = "Cadastrar um estabelecimento")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Void> newEstabelecimento(@RequestBody CreateUserDto dto) {

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());
        if (basicRole == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Basic role not found");
        }

        var userFromDb = userRepository.findByEmail(dto.email());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var newEstabelecimento = new Estabelecimento();
        newEstabelecimento.setNome(dto.nome());
        newEstabelecimento.setCpf(dto.cpf());
        newEstabelecimento.setEmail(dto.email());
        newEstabelecimento.setTelefone(dto.telefone());
        newEstabelecimento.setEndereco(dto.endereco());
        newEstabelecimento.setCnpj(dto.cnpj());
        newEstabelecimento.setRazao_social(dto.razao_social());
        newEstabelecimento.setAgencia(dto.agencia());
        newEstabelecimento.setConta_corrente(dto.conta_corrente());
        newEstabelecimento.setConta_corrente(dto.conta_corrente());
        newEstabelecimento.setSenha(passwordEncoder.encode(dto.senha()));
        newEstabelecimento.setMedia_avaliacao(dto.media_avaliacao());
        newEstabelecimento.setFuncionarios(dto.funcionarios());
        newEstabelecimento.setCategorias(dto.categorias());
        newEstabelecimento.setPedidos(dto.pedidos());
        newEstabelecimento.setPerfilEstabelecimento(dto.perfilEstabelecimento());
        newEstabelecimento.setRoles(basicRole);
        userRepository.save(newEstabelecimento);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Listar todos os estabelecimentos")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(estabelecimentoService.listarEstabelecimentos());
    }

    @Operation(summary = "Listar nomes dos estabelecimentos")
    @GetMapping(value = "/listar-nomes")
    public ResponseEntity<Object> telaListaProjection() {
        return ResponseEntity.ok(estabelecimentoService.listarEstabelecimentosProjection());
    }

    @Operation(summary = "Atualizar um estabelecimento por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id,
            @Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimento = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
        return ResponseEntity.ok("Estabelecimento atualizado com sucesso!");
    }

}
