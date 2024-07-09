package com.hipizza.demo.modules.categoria.controller;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarCategoria {

    @Autowired
    private CategoriaService categoriaService;

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


    @Operation(summary = "Buscar uma categoria por nome")
    @GetMapping(value = "/{nome}")
    public ResponseEntity<Long> buscarPorNome(@PathVariable String nome) {
        categoriaService.findByName(nome);
        return ResponseEntity.ok(categoriaService.findByName(nome));
    }

}
