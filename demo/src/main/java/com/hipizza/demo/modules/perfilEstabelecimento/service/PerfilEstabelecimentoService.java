package com.hipizza.demo.modules.perfilEstabelecimento.service;

import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;
import com.hipizza.demo.modules.perfilEstabelecimento.repository.PerfilEstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilEstabelecimentoService {
    @Autowired
    PerfilEstabelecimentoRepository perfilEstabelecimentoRepository;

    public void cadastrarPerfil(PerfilEstabelecimento perfilEstabelecimento) {
        perfilEstabelecimentoRepository.save(perfilEstabelecimento);
    }

    public List<PerfilEstabelecimento> listarPerfil() {
        return perfilEstabelecimentoRepository.findAll();
    }

    public List<PerfilEstabelecimento> getPerfilPorEstabelecimento(Long idEstabelecimento) {
        return perfilEstabelecimentoRepository.findByEstabelecimentoId(idEstabelecimento);
    }

    public void excluirPerfilPorId(Long id) {
        perfilEstabelecimentoRepository.deleteById(id);
    }

    public PerfilEstabelecimento atualizarPerfil(Long id, PerfilEstabelecimento perfilAlterado) {
        PerfilEstabelecimento perfilExistente = perfilEstabelecimentoRepository.getReferenceById(id);
        atualizarDados(perfilExistente, perfilAlterado);
        return perfilEstabelecimentoRepository.save(perfilExistente);
    }

    private void atualizarDados(PerfilEstabelecimento perfilExistente, PerfilEstabelecimento perfilAlterado) {
        perfilExistente.setNome(perfilAlterado.getNome());
        perfilExistente.setDescricao(perfilAlterado.getDescricao());
        perfilExistente.setFormasPagamento(perfilAlterado.getFormasPagamento());
        perfilExistente.setHorario_fechamento(perfilAlterado.getHorario_fechamento());
        perfilExistente.setTempo_entrega(perfilAlterado.getTempo_entrega());
        perfilExistente.setValor_entrega(perfilAlterado.getValor_entrega());
    }
}
