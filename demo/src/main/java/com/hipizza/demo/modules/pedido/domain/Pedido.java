package com.hipizza.demo.modules.pedido.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.enums.FormaPagamento;
import com.hipizza.demo.modules.enums.StatusPedido;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DB106_PedidoS")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB106_PED_ID")
    private Long id;

    @Column(name = "DB106_PED_VALOR_TOTAL")
    private BigDecimal valor_total;

    @Enumerated(EnumType.STRING)
    @Column(name = "DB106_PED_FORMA_PAGAMENTO", length = 30)
    @NotNull(message = "A forma de pagamento não pode ficar em branco!")
    private FormaPagamento forma_pagamento;

    @Column(name = "DB106_PED_OBS", length = 150)
    @Size(min = 1, max = 150, message = "Observação inválida!(Deve conter no máximo 150 caracteres)")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "DB106_PED_STATUS", length = 12)
    private StatusPedido status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedido> itensPedido = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "DB102_CON_ID")
    //@JsonBackReference
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "DB101_EST_ID")
    //@JsonBackReference
    private Estabelecimento estabelecimento;

}
