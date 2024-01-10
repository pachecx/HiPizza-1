package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Estabelecimento;
import com.hipizza.demo.domain.Funcionario;
import com.hipizza.demo.service.EstabelecimentoService;
import com.hipizza.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Funcionario funcionario) {
        funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<Funcionario>> getFuncionariosPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<Funcionario> funcionarios = funcionarioService.getFuncionariosPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(funcionarios);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        funcionarioService.excluirFuncionarioPorId(id);
        return ResponseEntity.ok("Funcionário excluído com sucesso!");
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok("Funcionário atualizado com sucesso!");
    }
}
