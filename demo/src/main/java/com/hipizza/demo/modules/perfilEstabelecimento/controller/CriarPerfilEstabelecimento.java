package com.hipizza.demo.modules.perfilEstabelecimento.controller;

import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;
import com.hipizza.demo.modules.perfilEstabelecimento.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CriarPerfilEstabelecimento extends BasePerfilEstabelecimentoController{

    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;

    @Operation(summary = "Cadastrar um perfil de estabelecimento")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimentoService.cadastrarPerfil(perfilEstabelecimento);
        return ResponseEntity.ok("Perfil cadastrado com sucesso!");
    }
}
