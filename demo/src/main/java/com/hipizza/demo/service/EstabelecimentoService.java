package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
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

    public Estabelecimento atualizarEstabelecimento(Long id, Estabelecimento estabelecimentoAlterado) {

        Estabelecimento estabelecimentoExistente = estabelecimentoRepository.getReferenceById(id);
        atualizarDados(estabelecimentoExistente, estabelecimentoAlterado);
        return estabelecimentoRepository.save(estabelecimentoExistente);

    }

    private void atualizarDados(Estabelecimento estabelecimentoExistente, Estabelecimento estabelecimentoAlterado) {
        estabelecimentoExistente.setAgencia(estabelecimentoAlterado.getAgencia());
        estabelecimentoExistente.setCnpj(estabelecimentoAlterado.getCnpj());
        estabelecimentoExistente.setCpf(estabelecimentoAlterado.getCpf());
        estabelecimentoExistente.setEmail(estabelecimentoExistente.getEmail());
        estabelecimentoExistente.setConta_corrente(estabelecimentoAlterado.getConta_corrente());
        estabelecimentoExistente.setNome(estabelecimentoAlterado.getNome());
        estabelecimentoExistente.setEndereco(estabelecimentoAlterado.getEndereco());
        estabelecimentoExistente.setRazao_social(estabelecimentoAlterado.getRazao_social());
        estabelecimentoExistente.setSenha(estabelecimentoAlterado.getSenha());
        estabelecimentoExistente.setTelefone(estabelecimentoAlterado.getTelefone());
    }
}