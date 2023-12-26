package com.hipizza.demo.service;

import com.hipizza.demo.domain.Estabelecimento;
import com.hipizza.demo.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;


    public void cadastrarEstabelecimento(Estabelecimento estabelecimento) {
         estabelecimentoRepository.save(estabelecimento);
    }

    public List<Estabelecimento> listarEstabelecimentos() {
        return estabelecimentoRepository.findAll();
    }

    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return estabelecimentoRepository.findById(id).orElse(null);
    }
}