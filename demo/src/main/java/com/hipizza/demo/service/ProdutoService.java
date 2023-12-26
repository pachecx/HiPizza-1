package com.hipizza.demo.service;

import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void cadastrarProduto(Produto produto) {
        produtoRepository.save(produto);
    }


    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
