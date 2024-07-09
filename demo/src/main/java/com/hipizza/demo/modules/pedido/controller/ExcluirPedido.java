package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirPedido extends BasePedidoController{

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Excluir um pedido por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }

}
