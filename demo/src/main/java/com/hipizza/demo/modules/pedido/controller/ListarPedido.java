package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarPedido extends BasePedidoController{

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Listar todos os pedidos")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @Operation(summary = "Listar pedidos por consumidor")
    @GetMapping("/listar-consumidor/{idConsumidor}")
    public ResponseEntity<List<Pedido>> getPedidosPorConsumidor(@PathVariable Long idConsumidor) {
        List<Pedido> pedidos = pedidoService.getPedidosPorConsumidor(idConsumidor);
        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Listar pedidos por estabelecimento")
    @GetMapping("/listar-estabelecimento/{idEstabelecimento}")
    public ResponseEntity<List<Pedido>> getPedidosPorEstabelecimento(
            @PathVariable Long idEstabelecimento) {
        List<Pedido> pedidos = pedidoService.getPedidosPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(pedidos);
    }

}
