package com.hipizza.demo.modules.categoria.repository;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByEstabelecimentoId(Long idEstabelecimento);
}
