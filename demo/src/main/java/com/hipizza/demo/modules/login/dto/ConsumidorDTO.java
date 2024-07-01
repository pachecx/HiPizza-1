package com.hipizza.demo.modules.login.dto;

import com.hipizza.demo.modules.roles.domain.Role;

public record ConsumidorDTO(
        String nome,
        String cpf,
        String email,
        String senha,
        String telefone,
        String cep,
        String estado,
        String cidade,
        String rua,
        String bairro,
        String complemento,
        String pontoReferencia
) {}