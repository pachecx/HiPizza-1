package com.hipizza.demo.modules.funcionario.repository;

import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByEstabelecimentoId(Long idEstabelecimento);
}
