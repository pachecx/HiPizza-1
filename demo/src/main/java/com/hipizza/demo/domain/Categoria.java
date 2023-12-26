package com.hipizza.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    //private List<Produto> produtos = new ArrayList<>();

}
