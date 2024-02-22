package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Avaliacao;
import com.hipizza.demo.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> incluir(@Validated @RequestBody Avaliacao avaliacao) {
        avaliacaoService.cadastrarAvaliacao(avaliacao);
        return ResponseEntity.ok("Avaliação cadastrada com sucesso!");
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(avaliacaoService.listarAvaliacoes());
    }

    @GetMapping("/listar-consumidor/{idConsumidor}")
    public ResponseEntity<List<Avaliacao>> getAvaliacaoPorEstabelecimento(@PathVariable Long idConsumidor) {
        List<Avaliacao> avaliacao = avaliacaoService.getAvaliacaoPorConsumidor(idConsumidor);
        return ResponseEntity.ok(avaliacao);
    }
    @GetMapping("/listar-estabelecimento/{idEstabelecimento}")
    public ResponseEntity<List<Avaliacao>> getAvaliacaoPorConsumidor(@PathVariable Long idEstabelecimento) {
        List<Avaliacao> avaliacao = avaliacaoService.getAvaliacaoPorEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(avaliacao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        avaliacaoService.excluirAvaliacaoPorId(id);
        return ResponseEntity.ok("Avaliação excluída com sucesso!");
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Long id, @Validated @RequestBody Avaliacao avaliacao) {
        avaliacao = avaliacaoService.atualizarAvaliacao(id,avaliacao);
        return ResponseEntity.ok("Avaliação atualizada com sucesso!");
    }

}
