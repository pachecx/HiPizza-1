package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Controle de categorias")
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Cadastrar uma categoria")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Categoria categoria) {
        categoriaService.cadastrarCategoria(categoria);
        return ResponseEntity.ok("Categoria cadastrada com sucesso!");
    }
    @Operation(summary = "Listar todas as categorias")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }
    @Operation(summary = "Listar categorias por estabelecimento")
    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<Categoria>> getCategoriasPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<Categoria> categorias = categoriaService.getCategoriasPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(categorias);
    }
    @Operation(summary = "Excluir uma categoria por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        categoriaService.excluirCategoriaPorId(id);
        return ResponseEntity.ok("Categoria excluída com sucesso!");
    }
    @Operation(summary = "Atualizar uma categoria por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Categoria categoria) {
        categoria = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }
}
