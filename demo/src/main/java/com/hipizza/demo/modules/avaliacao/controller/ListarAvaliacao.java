package com.hipizza.demo.modules.avaliacao.controller;

import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarAvaliacao extends BaseAvaliacaoController{

    @Autowired
    private AvaliacaoService avaliacaoService;

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

}
