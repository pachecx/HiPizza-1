package com.hipizza.demo.modules.consumidor.repository;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.projection.EstabelecimentoProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {
    List<EstabelecimentoProjection> findAllBy();

    Optional<Consumidor> findByEmail(String email);
}
