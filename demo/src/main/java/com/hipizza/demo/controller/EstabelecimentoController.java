package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Estabelecimento;
import com.hipizza.demo.service.EstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controle de estabelecimentos")

@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;
    @Operation(summary = "Cadastrar um estabelecimento")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
        return ResponseEntity.ok("Estabelecimento cadastrado com sucesso!");
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
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimento = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
        return ResponseEntity.ok("Estabelecimento atualizado com sucesso!");
    }

}
