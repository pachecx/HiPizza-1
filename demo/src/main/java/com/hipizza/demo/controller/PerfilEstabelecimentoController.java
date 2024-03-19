package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.PerfilEstabelecimento;
import com.hipizza.demo.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Controle de perfis de estabelecimento")
@RequestMapping(value = "/perfil-estabelecimento")
public class PerfilEstabelecimentoController {
    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;
    @Operation(summary = "Cadastrar um perfil de estabelecimento")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimentoService.cadastrarPerfil(perfilEstabelecimento);
        return ResponseEntity.ok("Perfil cadastrada com sucesso!");
    }
    @Operation(summary = "Listar todos os perfis de estabelecimento")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(perfilEstabelecimentoService.listarPerfil());
    }
    @Operation(summary = "Listar perfis de estabelecimento por ID do estabelecimento")
    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<PerfilEstabelecimento>> getPerfilPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<PerfilEstabelecimento> perfis = perfilEstabelecimentoService.getPerfilPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(perfis);
    }
    @Operation(summary = "Excluir um perfil de estabelecimento por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        perfilEstabelecimentoService.excluirPerfilPorId(id);
        return ResponseEntity.ok("Perfil excluído com sucesso!");
    }
    @Operation(summary = "Atualizar um perfil de estabelecimento por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimento = perfilEstabelecimentoService.atualizarPerfil(id, perfilEstabelecimento);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }
}
