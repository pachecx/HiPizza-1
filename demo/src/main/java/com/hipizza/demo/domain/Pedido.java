package com.hipizza.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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
    private BigDecimal valorTotal;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "consumidor_id")
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
