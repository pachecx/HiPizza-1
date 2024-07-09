package com.hipizza.demo.modules.estabelecimento.controller;

import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.modules.estabelecimento.service.EstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditarEstabelecimento extends BaseEstabelecimentoController{

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Operation(summary = "Atualizar um estabelecimento por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id,
                                          @Validated @RequestBody Estabelecimento estabelecimento) {
        estabelecimento = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
        return ResponseEntity.ok("Estabelecimento atualizado com sucesso!");
    }

}
