package com.hipizza.demo.modules.estabelecimento.service;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.estabelecimento.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastrarFuncionario(Consumidor.Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }


    public void excluirFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Consumidor.Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Consumidor.Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Consumidor.Funcionario> getFuncionariosPorEstabelecimento(Long idEstabelecimento) {
        return funcionarioRepository.findByEstabelecimentoId(idEstabelecimento);
    }

    public Consumidor.Funcionario atualizarFuncionario(Long id, Consumidor.Funcionario funcionarioAlterado) {

        Consumidor.Funcionario funcionarioExistente = funcionarioRepository.getReferenceById(id);
        atualizarDados(funcionarioExistente, funcionarioAlterado);
        return funcionarioRepository.save(funcionarioExistente);

    }

    private void atualizarDados(Consumidor.Funcionario funcionarioExistente, Consumidor.Funcionario funcionarioAlterado) {
        funcionarioExistente.setCpf(funcionarioAlterado.getCpf());
        funcionarioExistente.setEmail(funcionarioAlterado.getEmail());
        funcionarioExistente.setEndereco(funcionarioAlterado.getEndereco());
        funcionarioExistente.setFuncao(funcionarioAlterado.getFuncao());
        funcionarioExistente.setNome(funcionarioAlterado.getNome());
        funcionarioExistente.setSenha(funcionarioAlterado.getSenha());
        funcionarioExistente.setTelefone(funcionarioAlterado.getTelefone());
    }
}

