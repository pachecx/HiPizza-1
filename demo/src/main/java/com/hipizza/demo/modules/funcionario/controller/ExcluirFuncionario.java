package com.hipizza.demo.modules.funcionario.controller;

import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirFuncionario extends BaseFuncionarioController{

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Excluir um funcionário por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        funcionarioService.excluirFuncionarioPorId(id);
        return ResponseEntity.ok("Funcionário excluído com sucesso!");
    }

}
