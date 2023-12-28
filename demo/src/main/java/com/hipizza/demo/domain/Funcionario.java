package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Funcionario")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 80)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "endereco", length = 150)
    @NotBlank(message = "Endereço não pode ficar em branco!")
    @Size(min = 2, max = 150, message = "Endereço inválido!(Deve conter no máximo 150 dígitos)")
    private String endereco;

    @Column(name = "cpf", length = 11, unique = true)
    @NotBlank(message = "CPF não pode ficar em branco!")
    @Size(min = 11, max = 11, message = "CPF inválido!(Deve conter 11 dígitos)")
    @Pattern(regexp = "\\d*", message = "CPF deve conter apenas números")
    private String cpf;

    @Column(name = "telefone", length = 20)
    @NotBlank(message = "Telefone não pode ficar em branco!")
    @Size(min = 5, max = 20, message = "Telefone inválido!(Deve conter no máximo 20 dígitos)")
    @Pattern(regexp = "\\d*", message = "Telefone deve conter apenas números")
    private String telefone;

    @Column(name = "funcao", length = 11)
    @NotBlank(message = "Função não pode ficar em branco!")
    @Pattern(regexp = "entregador|atendente", message = "função deve ser: entregador ou atendente")
    private String funcao;

    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação

    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    @JsonBackReference
    private Estabelecimento estabelecimento;
}

