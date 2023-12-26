package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Estabelecimento;
import com.hipizza.demo.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@RequestBody Estabelecimento estabelecimento) {
        estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
        return ResponseEntity.ok("Estabelecimento cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(estabelecimentoService.listarEstabelecimentos());
    }

}
