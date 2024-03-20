package com.hipizza.demo.modules.estabelecimento.repository;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Consumidor.Funcionario, Long> {
    List<Consumidor.Funcionario> findByEstabelecimentoId(Long idEstabelecimento);
}
