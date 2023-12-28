package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Estabelecimento;
import com.hipizza.demo.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
        return ResponseEntity.ok("Estabelecimento cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(estabelecimentoService.listarEstabelecimentos());
    }

    @GetMapping(value = "/listanomes")
    public ResponseEntity<Object> telaListaProjection() {
        return ResponseEntity.ok(estabelecimentoService.listarEstabelecimentosProjection());
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimento = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
        return ResponseEntity.ok("Estabelecimento atualizado com sucesso!");
    }

}
