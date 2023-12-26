package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.repository.CategoriaRepository;
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

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    public List<Categoria> getCategoriasPorEstabelecimento(Long idEstabelecimento) {
        return categoriaRepository.findByEstabelecimentoId(idEstabelecimento);
    }
}
