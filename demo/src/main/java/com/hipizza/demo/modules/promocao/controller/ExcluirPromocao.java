package com.hipizza.demo.modules.promocao.controller;

import com.hipizza.demo.modules.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ExcluirPromocao extends BasePromocaoController{

    @Autowired
    private PromocaoService promocaoService;

    @Operation(summary = "Excluir uma promoção por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        promocaoService.excluirPromocaoPorId(id);
        return ResponseEntity.ok("Promoção excluída com sucesso!");
    }
}
