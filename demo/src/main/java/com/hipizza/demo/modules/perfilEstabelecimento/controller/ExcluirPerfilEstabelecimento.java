package com.hipizza.demo.modules.perfilEstabelecimento.controller;

import com.hipizza.demo.modules.perfilEstabelecimento.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ExcluirPerfilEstabelecimento extends BasePerfilEstabelecimentoController{

    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;

    @Operation(summary = "Excluir um perfil de estabelecimento por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        perfilEstabelecimentoService.excluirPerfilPorId(id);
        return ResponseEntity.ok("Perfil excluído com sucesso!");
    }
}
