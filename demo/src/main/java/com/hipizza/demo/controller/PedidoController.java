package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Pedido;
import com.hipizza.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);

         return ResponseEntity.ok("Pedido cadastrado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }
}
