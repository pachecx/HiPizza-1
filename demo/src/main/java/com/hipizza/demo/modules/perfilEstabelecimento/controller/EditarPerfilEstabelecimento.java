package com.hipizza.demo.modules.perfilEstabelecimento.controller;

import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;
import com.hipizza.demo.modules.perfilEstabelecimento.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EditarPerfilEstabelecimento extends BasePerfilEstabelecimentoController{

    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;

    @Operation(summary = "Atualizar um perfil de estabelecimento por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimento = perfilEstabelecimentoService.atualizarPerfil(id, perfilEstabelecimento);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }
}
