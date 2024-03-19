package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Consumidor;
import com.hipizza.demo.service.ConsumidorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controle de consumidores")
@RequestMapping(value = "/consumidor")
public class ConsumidorController {
    @Autowired
    private ConsumidorService consumidorService;
    @Operation(summary = "Cadastrar um consumidor")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Consumidor consumidor) {
        consumidorService.cadastrarConsumidor(consumidor);
        return ResponseEntity.ok("Consumidor cadastrado com sucesso!");
    }
    @Operation(summary = "Listar todos os consumidores")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(consumidorService.listarConsumidores());
    }

    @Operation(summary = "Atualizar um consumidor por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Consumidor consumidor) {
        consumidor = consumidorService.atualizarConsumidor(id, consumidor);
        return ResponseEntity.ok("Consumidor atualizado com sucesso!");
    }
}
