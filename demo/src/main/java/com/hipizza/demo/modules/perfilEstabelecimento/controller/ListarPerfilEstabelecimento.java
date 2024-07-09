package com.hipizza.demo.modules.perfilEstabelecimento.controller;

import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;
import com.hipizza.demo.modules.perfilEstabelecimento.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ListarPerfilEstabelecimento extends BasePerfilEstabelecimentoController{

    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;

    @Operation(summary = "Listar todos os perfis de estabelecimento")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(perfilEstabelecimentoService.listarPerfil());
    }

    @Operation(summary = "Listar perfis de estabelecimento por ID do estabelecimento")
    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<PerfilEstabelecimento>> getPerfilPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<PerfilEstabelecimento> perfis = perfilEstabelecimentoService.getPerfilPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(perfis);
    }
}
