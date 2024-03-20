package com.hipizza.demo.modules.produto.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hipizza.demo.modules.categoria.domain.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "DB108_produtos")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB108_PRO_ID")
    private Long id;

    @Column(name = "DB108_PRO_NOME", length = 80, nullable = false)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "DB108_PRO_DESCRICAO", length = 150, nullable = false)
    @NotBlank(message = "Descrição não pode ficar em branco!")
    @Size(min = 0, max = 150, message = "Descrição inválida!(Deve conter no máximo 150 caracteres)")
    private String descricao;

    @Column(name = "DB108_PRO_VALOR_UNITARIO", nullable = false)
    @NotNull(message = "O valor unitário não pode se nulo!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor unitário deve ser maior que zero.")
    @DecimalMax(value = "9999999.99", message = "O valor unitário não pode exceder 9.999.999,99.")
    private BigDecimal valor_unitario;

    @ManyToOne
    @JoinColumn(name = "DB103_CAT_ID")
    @JsonBackReference
    private Categoria categoria;
    
}
