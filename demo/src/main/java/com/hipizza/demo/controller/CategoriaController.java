package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Categoria categoria) {
        categoriaService.cadastrarCategoria(categoria);
        return ResponseEntity.ok("Categoria cadastrada com sucesso!");
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/listar/{idEstabelecimento}")
    public ResponseEntity<List<Categoria>> getCategoriasPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        List<Categoria> categorias = categoriaService.getCategoriasPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        categoriaService.excluirCategoriaPorId(id);
        return ResponseEntity.ok("Categoria excluída com sucesso!");
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Categoria categoria) {
        categoria = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }
}
