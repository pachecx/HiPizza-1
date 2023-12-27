package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/lista/{idCategoria}")
    public ResponseEntity<List<Produto>> getProdutoPorCategoria(@PathVariable Long idCategoria) {
        List<Produto> produtos = produtoService.getProdutosPorCategoria(idCategoria);
        return ResponseEntity.ok(produtos);
    }
}
