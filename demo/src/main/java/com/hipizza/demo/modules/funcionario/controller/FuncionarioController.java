package com.hipizza.demo.modules.funcionario.controller;
import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
@Tag(name = "Controle de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Cadastrar um funcionário")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Funcionario funcionario) {
        funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }
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
    @Operation(summary = "Excluir um funcionário por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        funcionarioService.excluirFuncionarioPorId(id);
        return ResponseEntity.ok("Funcionário excluído com sucesso!");
    }
    @Operation(summary = "Atualizar um funcionário por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok("Funcionário atualizado com sucesso!");
    }
}
