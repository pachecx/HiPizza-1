package com.hipizza.demo.modules.categoria.dto;

import java.util.List;

import com.hipizza.demo.modules.enums.Tamanho;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;

public record CategoriaDto(String nome, List<Tamanho> tamanho, String descricao, Estabelecimento estabelecimento) {

}
