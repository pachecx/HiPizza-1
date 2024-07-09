package com.hipizza.demo.modules.funcionario.controller;

import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarFuncionario extends BaseFuncionarioController{

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Listar todos os funcionários")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    @Operation(summary = "Listar funcionários por estabelecimento")
    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<Funcionario>> getFuncionariosPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<Funcionario> funcionarios = funcionarioService.getFuncionariosPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(funcionarios);
    }

}
