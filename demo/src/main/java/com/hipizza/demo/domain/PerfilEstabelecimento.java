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
@Table(name = "DB107_perfil_estabelecimento")
@Data
public class PerfilEstabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB107_PER_EST_ID")
    private Long id;

    @Column(name = "DB107_PER_EST_NOME", length = 80, nullable = false)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "DB107_PER_EST_DESCRICAO", length = 150)
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @Column(name = "DB107_PER_EST_VALOR_ENTREGA")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor unitário deve ser maior ou igual zero.")
    @DecimalMax(value = "9999999.99", message = "O valor unitário não pode exceder 9.999.999,99.")
    private BigDecimal valor_entrega;

    @Column(name = "DB107_PER_EST_TEMPO_ENTREGA")
    @Min(value = 1, message = "O tempo deve ser no mínimo 1")
    @Max(value = 999, message = "A tempo deve ser no máximo 999")
    private int tempo_entrega;//em minutos

    @Column(name = "DB107_PER_EST_HR_FECHAMENTO", length = 10)
    @Size(min = 0, max = 10, message = "Horário inválido!(Deve conter no máximo 10 caracteres)")
    private String horario_fechamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "DB107_PER_EST_FORMAS_PAGAMENTO")
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @Column(name = "DB107_PER_EST_PEDIDO_MINIMO")
    @NotNull
    private Integer pedido_minimo;

    @OneToOne
    @JoinColumn(name = "DB101_EST_ID")
    @JsonBackReference
    private Estabelecimento estabelecimento;
}
