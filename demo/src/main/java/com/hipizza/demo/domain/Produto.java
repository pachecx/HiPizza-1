package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tamanho")
    private String tamanho; // Pequeno, Médio, Grande (não obrigatório)
    @Column(name = "valor_unitario")
    private Double valor_unitario;
    @Column(name = "valor_promocao")
    private Double valor_promocao; // Não obrigatório
    @Column(name = "personalizacao")
    private boolean personalizacao; // Sim ou Não

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private Categoria categoria;
}
