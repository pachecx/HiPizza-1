package com.hipizza.demo.modules.avaliacao.controller;
import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao")
@Tag(name = "Controle de avaliações")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Operation(summary = "Cadastra uma avaliação")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Avaliacao avaliacao) {
        avaliacaoService.cadastrarAvaliacao(avaliacao);
        return ResponseEntity.ok("Avaliação cadastrada com sucesso!");
    }
    @Operation(summary ="Lista as avaliações")
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(avaliacaoService.listarAvaliacoes());
    }

    @Operation(summary = "Lista avaliações por consumidor")
    @GetMapping("/listar-consumidor/{idConsumidor}")
    public ResponseEntity<List<Avaliacao>> getAvaliacaoPorEstabelecimento(@PathVariable Long idConsumidor) {
        List<Avaliacao> avaliacao = avaliacaoService.getAvaliacaoPorConsumidor(idConsumidor);
        return ResponseEntity.ok(avaliacao);
    }

    @Operation(summary ="Lista avaliações por estabelecimento")
    @GetMapping("/listar-estabelecimento/{idEstabelecimento}")
    public ResponseEntity<List<Avaliacao>> getAvaliacaoPorConsumidor(@PathVariable Long idEstabelecimento) {
        List<Avaliacao> avaliacao = avaliacaoService.getAvaliacaoPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(avaliacao);
    }
    @Operation(summary ="Exclui avaliação por id")
    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        avaliacaoService.excluirAvaliacaoPorId(id);
        return ResponseEntity.ok("Avaliação excluída com sucesso!");
    }
    @Operation(summary ="Altera avaliação por id")
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Avaliacao avaliacao) {
        avaliacao = avaliacaoService.atualizarAvaliacao(id,avaliacao);
        return ResponseEntity.ok("Avaliação atualizada com sucesso!");
    }

}
