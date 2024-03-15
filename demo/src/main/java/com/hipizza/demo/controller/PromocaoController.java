package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Promocao;
import com.hipizza.demo.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/promocao")
@Tag(name = "Controle de promoções")
public class PromocaoController {
    @Autowired
    private PromocaoService promocaoService;
    @Operation(summary = "Cadastrar uma promoção")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Promocao promocao) {
        promocaoService.cadastrarPromocao(promocao);
        return ResponseEntity.ok("Promoção cadastrado com sucesso!");
    }
    @Operation(summary = "Listar todas as promoções")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(promocaoService.listarPromocoes());
    }
    @Operation(summary = "Excluir uma promoção por ID")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        promocaoService.excluirPromocaoPorId(id);
        return ResponseEntity.ok("Promoção excluída com sucesso!");
    }
    @Operation(summary = "Atualizar uma promoção por ID")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id,@Validated @RequestBody Promocao promocao) {
        promocao = promocaoService.atualizarPromocao(id, promocao);
        return ResponseEntity.ok("Promoção atualizada com sucesso!");
    }
    @Operation(summary = "Listar promoções por ID da categoria")
    @GetMapping("/listar/{idCategoria}")
    public ResponseEntity<List<Promocao>> getPromocaoPorCategoria(@PathVariable Long idCategoria) {
        List<Promocao> promocoes = promocaoService.getPromocoesPorCategoria(idCategoria);
        return ResponseEntity.ok(promocoes);
    }
}
