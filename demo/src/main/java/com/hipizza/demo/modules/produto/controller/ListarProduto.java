package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ListarProduto {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Listar produtos por ID da categoria")
    @GetMapping("/listar/{idCategoria}")
    public ResponseEntity<List<Produto>> getProdutoPorCategoria(@PathVariable Long idCategoria) {
        List<Produto> produtos = produtoService.getProdutosPorCategoria(idCategoria);
        return ResponseEntity.ok(produtos);
    }
}
