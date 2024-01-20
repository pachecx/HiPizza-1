package com.hipizza.demo.repository;

import com.hipizza.demo.domain.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
    List<Promocao> findByCategoriasId(Long idCategoria);
}
