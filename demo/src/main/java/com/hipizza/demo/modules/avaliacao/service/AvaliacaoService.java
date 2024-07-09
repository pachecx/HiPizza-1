package com.hipizza.demo.modules.avaliacao.service;

import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.consumidor.repository.ConsumidorRepository;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.modules.avaliacao.repository.AvaliacaoRepository;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private ConsumidorRepository consumidorRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public void cadastrarAvaliacao(Avaliacao avaliacao){
        avaliacaoRepository.save(avaliacao);
        atualizarMediaEstabelecimento(avaliacao.getEstabelecimento().getId());
    }

    public void excluirAvaliacaoPorId(Long id){
        avaliacaoRepository.deleteById(id);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> getAvaliacaoPorConsumidor(Long idConsumidor) {
        return avaliacaoRepository.findByConsumidorId(idConsumidor);
    }

    public List<Avaliacao> getAvaliacaoPorEstabelecimento(Long idEstabelecimento) {
        return avaliacaoRepository.findByEstabelecimentoId(idEstabelecimento);
    }

    public Avaliacao atualizarAvaliacao (Long id, Avaliacao avaliacaoAlterada){
        Avaliacao avaliacaoExistente = avaliacaoRepository.getReferenceById(id);
        atualizarDados(avaliacaoExistente, avaliacaoAlterada);
        atualizarMediaEstabelecimento(avaliacaoExistente.getId());
        return avaliacaoRepository.save(avaliacaoExistente);
    }

    public String obterNomePorId(Long idEstabelecimento){
        List<Avaliacao> estabelecimentos = avaliacaoRepository.findByEstabelecimentoId(idEstabelecimento);
        Estabelecimento estabelecimento = estabelecimentos.get(0).getEstabelecimento();
        return estabelecimento.getNome();
    }

    private void atualizarDados(Avaliacao avaliacaoExistente, Avaliacao avaliacaoAlterada) {
        avaliacaoExistente.setNota(avaliacaoAlterada.getNota());
        avaliacaoExistente.setDescricao(avaliacaoAlterada.getDescricao());
    }
    private Double calcularMedia(Long id){
        List<Avaliacao> avaliacoes = getAvaliacaoPorEstabelecimento(id);
        if (avaliacoes.isEmpty()){
            return 0.0;
        }
        Double soma = 0.0;
        for (Avaliacao avaliacao : avaliacoes ){
            soma += avaliacao.getNota();
        }
        return soma/avaliacoes.size();
    }
    private void atualizarMediaEstabelecimento(Long idEstabelecimento) {
        Double media = calcularMedia(idEstabelecimento);
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(idEstabelecimento).orElse(null);
        if (estabelecimento != null) {
            estabelecimento.setMedia_avaliacao(media);
            estabelecimentoRepository.save(estabelecimento);
        }
    }

}
