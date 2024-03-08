package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Pedido;
import com.hipizza.demo.service.PedidoService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

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

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @GetMapping("/listar-consumidor/{idConsumidor}")
    public ResponseEntity<List<Pedido>> getPedidosPorConsumidor(@PathVariable Long idConsumidor) {
        List<Pedido> pedidos = pedidoService.getPedidosPorConsumidor(idConsumidor);
        return ResponseEntity.ok(pedidos);
    }
    @GetMapping("/listar-estabelecimento/{idEstabelecimento}")
    public ResponseEntity<List<Pedido>> getPedidosPorEstabelecimento(
            @PathVariable Long idEstabelecimento) {
        List<Pedido> pedidos = pedidoService.getPedidosPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Pedido pedido){
        pedido = pedidoService.atualizarPedido(id,pedido);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }
}