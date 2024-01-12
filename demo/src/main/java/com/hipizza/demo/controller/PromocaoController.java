package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Promocao;
import com.hipizza.demo.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/promocao")
public class PromocaoController {
    @Autowired
    private PromocaoService promocaoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Promocao promocao) {
        promocaoService.cadastrarPromocao(promocao);
        return ResponseEntity.ok("Promoção cadastrado com sucesso!");
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(promocaoService.listarPromocoes());
    }

}
