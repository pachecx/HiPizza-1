package com.hipizza.demo.modules.consumidor.repository;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {
}
