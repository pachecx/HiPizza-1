package com.hipizza.demo.modules.consumidor.controller;

import com.hipizza.demo.modules.consumidor.service.ConsumidorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarConsumidor extends BaseConsumidorController{
    @Autowired
    ConsumidorService consumidorService;

    @Operation(summary = "Listar todos os consumidores")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(consumidorService.listarConsumidores());
    }

}
