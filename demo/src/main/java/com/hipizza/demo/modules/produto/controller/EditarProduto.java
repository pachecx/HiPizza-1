package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EditarProduto {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Atualizar um produto por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Produto produto) {
        produto = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }
}
