package com.hipizza.demo.repository;

import com.hipizza.demo.domain.PerfilEstabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilEstabelecimentoRepository extends JpaRepository<PerfilEstabelecimento, Long> {
    List<PerfilEstabelecimento> findByEstabelecimentoId(Long idEstabelecimento);
}
