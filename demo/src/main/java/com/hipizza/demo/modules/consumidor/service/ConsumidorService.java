package com.hipizza.demo.modules.consumidor.service;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.consumidor.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumidorService {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    public void cadastrarConsumidor(Consumidor consumidor) {
        consumidorRepository.save(consumidor);
    }

    public List<Consumidor> listarConsumidores() {
        return consumidorRepository.findAll();
    }


    public Consumidor buscarConsumidorPorId(Long id) {
        return consumidorRepository.findById(id).orElse(null);
    }

    public Consumidor atualizarConsumidor(Long id, Consumidor consumidorAlterado) {

        Consumidor consumidorExistente = consumidorRepository.getReferenceById(id);
        atualizarDados(consumidorExistente, consumidorAlterado);
        return consumidorRepository.save(consumidorExistente);

    }

    private void atualizarDados(Consumidor consumidorExistente, Consumidor consumidorAlterado) {
        consumidorExistente.setCpf(consumidorAlterado.getCpf());
        consumidorExistente.setEmail(consumidorAlterado.getEmail());
        consumidorExistente.setBairro(consumidorAlterado.getBairro());
        consumidorExistente.setCep(consumidorAlterado.getCep());
        consumidorExistente.setCidade(consumidorAlterado.getCidade());
        consumidorExistente.setEstado(consumidorAlterado.getEstado());
        consumidorExistente.setTelefone(consumidorAlterado.getTelefone());
        consumidorExistente.setSenha(consumidorAlterado.getSenha());
        consumidorExistente.setPonto_referencia(consumidorAlterado.getPonto_referencia());
        consumidorExistente.setRua(consumidorAlterado.getRua());
        consumidorExistente.setNome(consumidorAlterado.getNome());
        consumidorExistente.setComplemento(consumidorAlterado.getComplemento());
    }
}
