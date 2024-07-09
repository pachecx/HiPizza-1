package com.hipizza.demo.modules.promocao.controller;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import com.hipizza.demo.modules.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ListarPromocao extends BasePromocaoController{

    @Autowired
    private PromocaoService promocaoService;

    @Operation(summary = "Listar todas as promoções")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(promocaoService.listarPromocoes());
    }

    @Operation(summary = "Listar promoções por ID da categoria")
    @GetMapping("/listar/{idCategoria}")
    public ResponseEntity<List<Promocao>> getPromocaoPorCategoria(@PathVariable Long idCategoria) {
        List<Promocao> promocoes = promocaoService.getPromocoesPorCategoria(idCategoria);
        return ResponseEntity.ok(promocoes);
    }
}
