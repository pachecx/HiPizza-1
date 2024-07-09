package com.hipizza.demo.modules.consumidor.controller;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.consumidor.service.ConsumidorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditarConsumidor extends BaseConsumidorController{

    @Autowired
    private ConsumidorService consumidorService;

    @Operation(summary = "Atualizar um consumidor por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Consumidor consumidor) {
        consumidor = consumidorService.atualizarConsumidor(id, consumidor);
        return ResponseEntity.ok("Consumidor atualizado com sucesso!");
    }

}
