package com.hipizza.demo.modules.consumidor.controller;

import com.hipizza.demo.modules.consumidor.service.ConsumidorService;
import com.hipizza.demo.modules.login.dto.ConsumidorDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarConsumidor extends BaseConsumidorController{

    @Autowired
    private ConsumidorService consumidorService;

    @Operation(summary = "Cadastrar um consumidor")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody ConsumidorDTO consumidor) {
        consumidorService.cadastrarConsumidor(consumidor);
        return ResponseEntity.ok("Consumidor cadastrado com sucesso!");
    }

}
