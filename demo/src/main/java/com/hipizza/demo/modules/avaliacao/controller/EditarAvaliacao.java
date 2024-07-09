package com.hipizza.demo.modules.avaliacao.controller;

import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class EditarAvaliacao extends BaseAvaliacaoController{

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary ="Altera avaliação por id")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Avaliacao avaliacao) {
        avaliacao = avaliacaoService.atualizarAvaliacao(id,avaliacao);
        return ResponseEntity.ok("Avaliação atualizada com sucesso!");
    }
}
