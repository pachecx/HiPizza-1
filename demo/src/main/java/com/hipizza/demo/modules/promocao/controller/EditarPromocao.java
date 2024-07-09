package com.hipizza.demo.modules.promocao.controller;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import com.hipizza.demo.modules.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EditarPromocao extends BasePromocaoController{

    @Autowired
    private PromocaoService promocaoService;

    @Operation(summary = "Atualizar uma promoção por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Promocao promocao) {
        promocao = promocaoService.atualizarPromocao(id, promocao);
        return ResponseEntity.ok("Promoção atualizada com sucesso!");
    }
}
