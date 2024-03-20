package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
@Tag(name = "Controle de pedidos")
public class PedidoController {
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
    @Operation(summary = "Excluir um pedido por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }
    @Operation(summary = "Atualizar um pedido por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Pedido pedido){
        pedido = pedidoService.atualizarPedido(id,pedido);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }
}