package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hipizza.demo.enums.FormaPagamento;
import com.hipizza.demo.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @Column(name = "valor_total")
    private BigDecimal valor_total;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", length = 30)
    private FormaPagamento forma_pagamento;

    @Column(name = "observacao", length = 150)
    @Size(min = 1, max = 150, message = "Observação inválida!(Deve conter no máximo 150 caracteres)")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 12)
    private StatusPedido status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemPedido> itensPedido = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "consumidor_id")
    @JsonBackReference
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    @JsonBackReference
    private Estabelecimento estabelecimento;

}
