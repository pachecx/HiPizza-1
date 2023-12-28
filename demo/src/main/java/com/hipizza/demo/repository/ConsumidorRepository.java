package com.hipizza.demo.repository;

import com.hipizza.demo.domain.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {
}
