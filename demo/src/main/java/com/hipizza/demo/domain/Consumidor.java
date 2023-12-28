package com.hipizza.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Consumidor")
@Data
public class Consumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 80)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    @NotBlank(message = "CPF não pode ficar em branco!")
    @Size(min = 11, max = 11, message = "CPF inválido!(Deve conter no máximo 11 dígitos)")
    @Pattern(regexp = "\\d*", message = "CPF deve conter apenas números")
    private String cpf;

    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação

    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação


    @Column(name = "telefone", length = 20)
    @NotBlank(message = "Telefone não pode ficar em branco!")
    @Size(min = 5, max = 20, message = "Telefone inválido!(Deve conter no máximo 20 dígitos)")
    @Pattern(regexp = "\\d*", message = "Telefone deve conter apenas números")
    private String telefone;

    @Column(name = "cep", length = 10)
    @NotBlank(message = "CEP não pode ficar em branco!")
    @Size(min = 8, max = 8, message = "CEP inválido!(Deve conter 8 dígitos)")
    @Pattern(regexp = "\\d*", message = "CEP deve conter apenas números")
    private String cep;

    @Column(name = "estado", length = 20)
    @NotBlank(message = "Estado não pode ficar em branco!")
    @Size(min = 1, max = 20, message = "Estado inválido!(Deve conter no máximo 20 caracteres)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ]+$", message = "Estado inválido! (Deve conter apenas letras e acentos)")
    private String estado;

    @Column(name = "cidade", length = 50)
    @NotBlank(message = "Cidade não pode ficar em branco!")
    @Size(min = 1, max = 50, message = "Cidade inválido!(Deve conter no máximo 50 caracteres)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ]+$", message = "Estado inválido! (Deve conter apenas letras e acentos)")
    private String cidade;

    @Column(name = "rua", length = 70)
    @NotBlank(message = "Rua não pode ficar em branco!")
    @Size(min = 1, max = 70, message = "Rua inválida!(Deve conter no máximo 70 caracteres)")
    private String rua;

    @Column(name = "bairro", length = 70)
    @NotBlank(message = "Bairro não pode ficar em branco!")
    @Size(min = 1, max = 70, message = "Bairro inválido!(Deve conter no máximo 70 caracteres)")
    private String bairro;

    @Column(name = "complemento", length = 85)
    @NotBlank(message = "Complemento não pode ficar em branco!")
    @Size(min = 1, max = 85, message = "Complemento inválido!(Deve conter no máximo 85 caracteres)")
    private String complemento;

    @Column(name = "ponto_referencia", length = 70)
    @Size(min = 1, max = 70, message = "Ponto de referência inválido!(Deve conter no máximo 70 caracteres)")
    private String ponto_referencia;
}
