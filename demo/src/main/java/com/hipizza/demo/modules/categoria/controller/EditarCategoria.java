package com.hipizza.demo.modules.categoria.controller;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditarCategoria {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Atualizar uma categoria por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Categoria categoria) {
        categoria = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }

}
