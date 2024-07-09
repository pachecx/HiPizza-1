package com.hipizza.demo.modules.consumidor.controller;

import com.hipizza.demo.modules.consumidor.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirConsumidor extends BaseConsumidorController{

    @Autowired
    private ConsumidorService consumidorService;

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        String response = consumidorService.excluirConsumidor(id);
        return ResponseEntity.ok().body(response);
    }

}
