package com.hipizza.demo.repository;

import com.hipizza.demo.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByConsumidorId(Long idConsumidor);
}
