package com.hipizza.demo.modules.login.dto;

import java.util.List;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;

public record CreateUserDto(String nome, String cpf, String email, String telefone, String endereco, String cnpj,
        String razao_social,
        String agencia, String conta_corrente, String senha, Double media_avaliacao, List<Funcionario> funcionarios,
        List<Categoria> categorias, List<Pedido> pedidos, PerfilEstabelecimento perfilEstabelecimento) {
}
