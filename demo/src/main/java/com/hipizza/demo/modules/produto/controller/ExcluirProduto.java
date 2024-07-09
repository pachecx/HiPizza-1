package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ExcluirProduto {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Excluir um produto por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        produtoService.excluirProdutoPorId(id);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }
}
