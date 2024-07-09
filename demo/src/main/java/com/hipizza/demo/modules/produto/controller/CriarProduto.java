package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CriarProduto {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Cadastrar um produto")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }
}
