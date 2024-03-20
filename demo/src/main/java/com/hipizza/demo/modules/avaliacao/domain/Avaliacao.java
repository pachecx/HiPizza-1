package com.hipizza.demo.modules.avaliacao.domain;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "DB111_avaliacao")
@Data

public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "DB111_AVAL_ID")
    private Long id;

    @Column(name = "DB111_AVAL_NOTA")
    @Min(0)
    @Max(5)
    private Integer nota;

    @Column(name = "DB111_AVAL_DATA_HORA")
    private LocalDateTime data_hora = LocalDateTime.now().withSecond(0).withNano(0);


    @Column(name = "DB111_AVAL_DESCRICAO")
    @Size(max = 250, message = "A descrição deve contem no máximo 250 caracteres")
    private String descricao;

    //@Column(name = "DB111_AVAL_FOTO")
    //@Lob
    //private byte[] foto;


    @ManyToOne
    @JoinColumn(name = "DB102_CON_ID")
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "DB101_EST_ID")
    private Estabelecimento estabelecimento;

}
