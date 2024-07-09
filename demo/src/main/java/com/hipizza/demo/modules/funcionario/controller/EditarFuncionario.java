package com.hipizza.demo.modules.funcionario.controller;

import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditarFuncionario extends BaseFuncionarioController{

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Atualizar um funcionário por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok("Funcionário atualizado com sucesso!");
    }
}
