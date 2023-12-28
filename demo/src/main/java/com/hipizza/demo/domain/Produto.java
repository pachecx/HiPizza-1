package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 80)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "descricao", length = 150)
    @NotBlank(message = "Descrição não pode ficar em branco!")
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @Column(name = "tamanho", length = 10)
    @Pattern(regexp = "pequeno|médio|grande", message = "tamanho deve ser: pequeno, médio ou grande")
    private String tamanho;

    @Column(name = "valor_unitario")
    @NotNull(message = "O valor unitário não pode ficar em branco!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor unitário deve ser maior que zero.")
    @DecimalMax(value = "9999999.99", message = "O valor unitário não pode exceder 9.999.999,99.")
    private BigDecimal valor_unitario;

    @Column(name = "valor_promocao")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor da promoção deve ser maior que zero.")
    @DecimalMax(value = "9999999.99", message = "O valor da promoção não pode exceder 9.999.999,99.")
    private BigDecimal valor_promocao;

    @Column(name = "personalizacao", length = 5)
    @NotBlank(message = "Personalização não pode ficar em branco!")
    @Pattern(regexp = "sim|não", message = "Personalização deve ser 'Sim' ou 'Não'.")
    private String personalizacao; // "Sim" ou "Não"

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private Categoria categoria;
}
