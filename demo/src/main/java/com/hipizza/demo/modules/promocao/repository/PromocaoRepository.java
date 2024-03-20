package com.hipizza.demo.modules.promocao.repository;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
    List<Promocao> findByCategoriasId(Long idCategoria);
}
