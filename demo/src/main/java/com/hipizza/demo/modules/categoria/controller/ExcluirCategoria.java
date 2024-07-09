package com.hipizza.demo.modules.categoria.controller;

import com.hipizza.demo.modules.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirCategoria {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Excluir uma categoria por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        categoriaService.excluirCategoriaPorId(id);
        return ResponseEntity.ok("Categoria excluída com sucesso!");
    }

}
