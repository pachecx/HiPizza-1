package com.hipizza.demo.modules.categoria.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hipizza.demo.modules.enums.Tamanho;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.promocao.domain.Promocao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DB103_categorias")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB103_CAT_ID")
    private Long id;

    @Column(name = "DB103_CAT_NOME", length = 80, nullable = false)
    @NotBlank(message = "Nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "DB103_CAT_TAMANHO", length = 10)
    //@Pattern(regexp = "pequeno|médio|grande", message = "tamanho deve ser: pequeno, médio ou grande")
    private Tamanho tamanho;

    @Column(name = "DB103_CAT_DESCRICAO", length = 150)
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();

    @ManyToMany(mappedBy = "categorias")
    @JsonManagedReference
    @JsonIgnore
    private List<Promocao> promocoes = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "DB101_EST_ID")
    @JsonBackReference
    private Estabelecimento estabelecimento;

}
