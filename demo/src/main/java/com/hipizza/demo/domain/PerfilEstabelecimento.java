package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hipizza.demo.enums.FormaPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PerfilEstabelecimento")
@Data
public class PerfilEstabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 80)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "descricao", length = 150)
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @Column(name = "valor_entrega")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor unitário deve ser maior ou igual zero.")
    @DecimalMax(value = "9999999.99", message = "O valor unitário não pode exceder 9.999.999,99.")
    private BigDecimal valor_entrega;

    @Column(name = "tempo_entrega")
    @Min(value = 1, message = "O tempo deve ser no mínimo 1")
    @Max(value = 999, message = "A tempo deve ser no máximo 999")
    private int tempo_entrega;//em minutos

    @Column(name = "horario_fechamento", length = 10)
    @Size(min = 0, max = 10, message = "Horário inválido!(Deve conter no máximo 10 caracteres)")
    private String horario_fechamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "formasPagamento")
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "estabelecimento_id")
    @JsonBackReference
    private Estabelecimento estabelecimento;
}
