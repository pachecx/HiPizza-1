package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@RequestBody Categoria categoria) {
        categoriaService.cadastrarCategoria(categoria);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/lista/{idEstabelecimento}")
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
    public ResponseEntity<String> alterar(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }
}
