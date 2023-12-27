package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
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

    public List<Produto> getProdutosPorCategoria(Long idCategoria) {
        return produtoRepository.findByCategoriaId(idCategoria);
    }

    public Produto atualizarProduto(Long id, Produto produtoAlterado) {

        Produto produtoExistente = produtoRepository.getReferenceById(id);
        atualizarDados(produtoExistente, produtoAlterado);
        return produtoRepository.save(produtoExistente);

    }

    private void atualizarDados(Produto produtoExistente, Produto produtoAlterado) {
        produtoExistente.setNome(produtoAlterado.getNome());
        produtoExistente.setDescricao(produtoAlterado.getDescricao());
        produtoExistente.setTamanho(produtoAlterado.getTamanho());
        produtoExistente.setPersonalizacao(produtoAlterado.getPersonalizacao());
        produtoExistente.setValor_promocao(produtoAlterado.getValor_promocao());
        produtoExistente.setValor_unitario(produtoAlterado.getValor_unitario());
        produtoExistente.setCategoria(produtoAlterado.getCategoria());
    }
}
