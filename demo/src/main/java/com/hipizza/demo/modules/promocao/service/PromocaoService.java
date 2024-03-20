package com.hipizza.demo.modules.promocao.service;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import com.hipizza.demo.modules.promocao.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoService {
    @Autowired
    private PromocaoRepository promocaoRepository;

    public void cadastrarPromocao(Promocao promocao) {
        promocaoRepository.save(promocao);
    }

    public List<Promocao> listarPromocoes() {
        return promocaoRepository.findAll();
    }

    public List<Promocao> getPromocoesPorCategoria(Long idCategoria) {
        return promocaoRepository.findByCategoriasId(idCategoria);}

    public void excluirPromocaoPorId(Long id){  promocaoRepository.deleteById(id); }
    public Promocao atualizarPromocao(Long id, Promocao promocaoAlterada){

        Promocao promocaoExistente = promocaoRepository.getReferenceById(id);
        atualizarDados(promocaoExistente, promocaoAlterada);
        return promocaoRepository.save(promocaoExistente);
    }

    private void atualizarDados(Promocao promocaoExistente, Promocao promocaoAlterada) {
        promocaoExistente.setNome(promocaoAlterada.getNome());
        promocaoExistente.setDescricao(promocaoAlterada.getDescricao());
        promocaoExistente.setValor_promocao(promocaoAlterada.getValor_promocao());
        promocaoExistente.setTamanho(promocaoAlterada.getTamanho());
        promocaoExistente.setCategorias(promocaoAlterada.getCategorias());
    }
}
