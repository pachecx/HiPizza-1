package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarPedido extends BasePedidoController{

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Fazer um pedido")
    @PostMapping("/fazer")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        try{
            pedidoService.cadastrarPedido(pedido);
            return ResponseEntity.ok("Pedido realizado com sucesso!");
        } catch (EntityExistsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).header("X-Error-Message", e.getMessage()).body("O valor do pedido têm que ser maior ou igual ao pedido mínimo do restaurante");
        }
    }

}
