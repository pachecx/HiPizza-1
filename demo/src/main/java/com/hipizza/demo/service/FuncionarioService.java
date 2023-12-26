package com.hipizza.demo.service;

import com.hipizza.demo.domain.Funcionario;
import com.hipizza.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }


    public void excluirFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
}

