package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.PerfilEstabelecimento;
import com.hipizza.demo.repository.PerfilEstabelecimentoRepository;
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
}
