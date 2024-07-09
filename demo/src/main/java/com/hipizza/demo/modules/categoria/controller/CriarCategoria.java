package com.hipizza.demo.modules.categoria.controller;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarCategoria extends BaseCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Cadastrar uma categoria")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Categoria categoria) {
        categoriaService.cadastrarCategoria(categoria);
        return ResponseEntity.ok("Categoria cadastrada com sucesso!");
    }

}
