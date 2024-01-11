package com.hipizza.demo.domain;

import com.hipizza.demo.enums.Tamanho;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DB109_promocao")
@Data
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB109_PRO_ID")
    private Long id;

    @Column(name = "DB109_PRO_NOME", length = 80, nullable = false)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "DB109_PRO_DESCRICAO", length = 150, nullable = false)
    @NotBlank(message = "Descrição não pode ficar em branco!")
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @Column(name = "DB109_PRO_VALOR_PROMOCAO", nullable = false)
    @NotNull(message = "O valor não pode se nulo!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor unitário deve ser maior que zero.")
    @DecimalMax(value = "9999999.99", message = "O valor unitário não pode exceder 9.999.999,99.")
    private BigDecimal valor_promocao;

    @Enumerated(EnumType.STRING)
    @Column(name = "DB109_PRO_TAMANHOS")
    private List<Tamanho> tamanho;
}
