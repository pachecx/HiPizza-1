package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.PerfilEstabelecimento;
import com.hipizza.demo.service.PerfilEstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/perfil-estabelecimento")
public class PerfilEstabelecimentoController {
    @Autowired
    private PerfilEstabelecimentoService perfilEstabelecimentoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimentoService.cadastrarPerfil(perfilEstabelecimento);
        return ResponseEntity.ok("Perfil cadastrada com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(perfilEstabelecimentoService.listarPerfil());
    }
}