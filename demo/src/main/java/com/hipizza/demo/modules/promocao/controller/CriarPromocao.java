package com.hipizza.demo.modules.promocao.controller;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import com.hipizza.demo.modules.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CriarPromocao extends BasePromocaoController{

    @Autowired
    private PromocaoService promocaoService;

    @Operation(summary = "Cadastrar uma promoção")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Promocao promocao) {
        promocaoService.cadastrarPromocao(promocao);
        return ResponseEntity.ok("Promoção cadastrado com sucesso!");
    }
}
