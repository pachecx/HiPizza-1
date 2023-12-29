package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hipizza.demo.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedido")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor_total")
    private BigDecimal valor_total;

    @Column(name = "forma_pagamento")
    private String forma_pagamento;

    @Column(name = "observacao")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "consumidor_id")
    private Consumidor consumidor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

}
