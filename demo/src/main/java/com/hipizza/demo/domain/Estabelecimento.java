package com.hipizza.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estabelecimento")
@Data
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razao_social;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "conta_corrente")
    private String conta_corrente;
    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private List<Categoria> categorias = new ArrayList<>();
}
