package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DB102_consumidores")
@Data
public class Consumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB102_CON_ID")
    private Long id;

    @Column(name = "DB102_CON_NOME", length = 80, nullable = false)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ]+$", message = "Nome inválido! (Deve conter apenas letras e acentos)")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "DB102_CON_CPF", length = 11, unique = true, nullable = false)
    @NotBlank(message = "CPF não pode ficar em branco!")
    @Size(min = 11, max = 11, message = "CPF inválido!(Deve conter 11 dígitos)")
    @Pattern(regexp = "\\d*", message = "CPF deve conter apenas números")
    private String cpf;

    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação

    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação


    @Column(name = "DB102_CON_TELEFONE", length = 20, nullable = false)
    @NotBlank(message = "Telefone não pode ficar em branco!")
    @Size(min = 5, max = 20, message = "Telefone inválido!(Deve conter no máximo 20 dígitos)")
    @Pattern(regexp = "\\d*", message = "Telefone deve conter apenas números")
    private String telefone;

    @Column(name = "DB102_CON_CEP", length = 10, nullable = false)
    @NotBlank(message = "CEP não pode ficar em branco!")
    @Size(min = 8, max = 8, message = "CEP inválido!(Deve conter 8 dígitos)")
    @Pattern(regexp = "\\d*", message = "CEP deve conter apenas números")
    private String cep;

    @Column(name = "DB102_CON_ESTADO", length = 20, nullable = false)
    @NotBlank(message = "Estado não pode ficar em branco!")
    @Size(min = 1, max = 20, message = "Estado inválido!(Deve conter no máximo 20 caracteres)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ]+$", message = "Estado inválido! (Deve conter apenas letras e acentos)")
    private String estado;

    @Column(name = "DB102_CON_CIDADE", length = 50, nullable = false)
    @NotBlank(message = "Cidade não pode ficar em branco!")
    @Size(min = 1, max = 50, message = "Cidade inválido!(Deve conter no máximo 50 caracteres)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ]+$", message = "Estado inválido! (Deve conter apenas letras e acentos)")
    private String cidade;

    @Column(name = "DB102_CON_RUA", length = 70, nullable = false)
    @NotBlank(message = "Rua não pode ficar em branco!")
    @Size(min = 1, max = 70, message = "Rua inválida!(Deve conter no máximo 70 caracteres)")
    private String rua;

    @Column(name = "DB102_CON_BAIRRO", length = 70, nullable = false)
    @NotBlank(message = "Bairro não pode ficar em branco!")
    @Size(min = 1, max = 70, message = "Bairro inválido!(Deve conter no máximo 70 caracteres)")
    private String bairro;

    @Column(name = "DB102_CON_COMPLEMENTO", length = 85, nullable = false)
    @NotBlank(message = "Complemento não pode ficar em branco!")
    @Size(min = 1, max = 85, message = "Complemento inválido!(Deve conter no máximo 85 caracteres)")
    private String complemento;

    @Column(name = "DB102_CON_PONTO_REFERENCIA", length = 70)
    @Size(min = 1, max = 70, message = "Ponto de referência inválido!(Deve conter no máximo 70 caracteres)")
    private String ponto_referencia;

    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();
}
