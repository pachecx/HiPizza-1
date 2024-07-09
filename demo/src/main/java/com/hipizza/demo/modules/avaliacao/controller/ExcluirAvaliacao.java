package com.hipizza.demo.modules.avaliacao.controller;

import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirAvaliacao extends BaseAvaliacaoController{

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary ="Exclui avaliação por id")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        avaliacaoService.excluirAvaliacaoPorId(id);
        return ResponseEntity.ok("Avaliação excluída com sucesso!");
    }
}
