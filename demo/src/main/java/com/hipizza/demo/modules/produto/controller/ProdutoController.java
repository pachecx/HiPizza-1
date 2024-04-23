package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@Tag(name = "Controle de produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Operation(summary = "Cadastrar um produto")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }
    @Operation(summary = "Listar todos os produtos")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }
    @Operation(summary = "Listar produtos por ID da categoria")
    @GetMapping("/listar/{idCategoria}")
    public ResponseEntity<List<Produto>> getProdutoPorCategoria(@PathVariable Long idCategoria) {
        List<Produto> produtos = produtoService.getProdutosPorCategoria(idCategoria);
        return ResponseEntity.ok(produtos);
    }
    @Operation(summary = "Excluir um produto por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        produtoService.excluirProdutoPorId(id);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }
    @Operation(summary = "Atualizar um produto por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id,@Validated @RequestBody Produto produto) {
        produto = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }
}
