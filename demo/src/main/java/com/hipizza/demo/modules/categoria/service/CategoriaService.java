package com.hipizza.demo.modules.categoria.service;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void excluirCategoriaPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Long findByName(String nome) {
        var categoriaExitente = categoriaRepository.findByNome(nome);
        var userOptional = categoriaExitente.get();
        var id = userOptional.getId();

        return id;
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<Categoria> getCategoriasPorEstabelecimento(Long idEstabelecimento) {
        return categoriaRepository.findByEstabelecimentoId(idEstabelecimento);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoriaAlterada) {

        Categoria categoriaExistente = categoriaRepository.getReferenceById(id);
        atualizarDados(categoriaExistente, categoriaAlterada);
        return categoriaRepository.save(categoriaExistente);

    }

    private void atualizarDados(Categoria categoriaExistente, Categoria categoriaAlterada) {
        categoriaExistente.setNome(categoriaAlterada.getNome());
        categoriaExistente.setTamanho(categoriaAlterada.getTamanho());
        categoriaExistente.setDescricao(categoriaAlterada.getDescricao());
    }
}
