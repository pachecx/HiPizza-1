package com.hipizza.demo.modules.avaliacao.controller;

import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarAvaliacao extends BaseAvaliacaoController{

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary = "Cadastra uma avaliação")
    @PostMapping(value = "cadastrar")

    public ResponseEntity<String> incluir(@Validated @RequestBody Avaliacao avaliacao) {
        avaliacaoService.cadastrarAvaliacao(avaliacao);
        return ResponseEntity.ok("Avaliação cadastrada com sucesso!");
    }

}
