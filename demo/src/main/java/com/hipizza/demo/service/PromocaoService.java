package com.hipizza.demo.service;

import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.domain.Promocao;
import com.hipizza.demo.repository.PromocaoRepository;
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

    public List<Promocao> listarPromocoess() {
        return promocaoRepository.findAll();
    }
}
