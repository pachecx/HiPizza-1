package com.hipizza.demo.modules.estabelecimento.controller;

import com.hipizza.demo.modules.estabelecimento.service.EstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarEstabelecimento extends BaseEstabelecimentoController{

    @Autowired
    private EstabelecimentoService estabelecimentoService;

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

}
