package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/listar/{idCategoria}")
    public ResponseEntity<List<Produto>> getProdutoPorCategoria(@PathVariable Long idCategoria) {
        List<Produto> produtos = produtoService.getProdutosPorCategoria(idCategoria);
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        produtoService.excluirProdutoPorId(id);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id,@Validated @RequestBody Produto produto) {
        produto = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }
}
