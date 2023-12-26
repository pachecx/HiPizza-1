package com.hipizza.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Funcionario")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "funcao")
    private String funcao; // Entregador ou Atendente
    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação
    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;
}

