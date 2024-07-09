package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditarPedido extends BasePedidoController{

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Atualizar um pedido por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Pedido pedido){
        pedido = pedidoService.atualizarPedido(id,pedido);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }

}
