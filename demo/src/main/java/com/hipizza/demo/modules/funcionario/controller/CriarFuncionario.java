package com.hipizza.demo.modules.funcionario.controller;

import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarFuncionario extends BaseFuncionarioController{

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Cadastrar um funcionário")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Funcionario funcionario) {
        funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }
}
