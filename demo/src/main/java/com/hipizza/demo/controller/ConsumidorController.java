package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Consumidor;
import com.hipizza.demo.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consumidor")
public class ConsumidorController {
    @Autowired
    private ConsumidorService consumidorService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Consumidor consumidor) {
        consumidorService.cadastrarConsumidor(consumidor);
        return ResponseEntity.ok("Consumidor cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(consumidorService.listarConsumidores());
    }


    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Consumidor consumidor) {
        consumidor = consumidorService.atualizarConsumidor(id, consumidor);
        return ResponseEntity.ok("Consumidor atualizado com sucesso!");
    }
}
