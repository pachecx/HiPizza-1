package com.hipizza.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity //marcando a classe como entidade no db
@Table(name = "DB111_avaliacao") //nomenado a nova tabela no db
@Data //inclui os métodos

public class Avaliacao {
    @Id //indicando PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "DB111_AVAL_ID")
    private Long id;

    @Column(name = "DB111_AVAL_NOTA")
    //isso é pra string @Size(min = 0,max = 5)
    @Min(0)
    @Max(5)
    private Integer nota;

    private LocalDateTime dataHora = LocalDateTime.now().withSecond(0).withNano(0);


    @Column(name = "DB111_AVAL_DESCRICAO")
    @Size(max = 250, message = "A descrição deve contem no máximo 250 caracteres")
    private String descricao;

    //@Column(name = "DB110_AVAL_FOTO")
    //@Lob
    //private byte[] foto;


    @ManyToOne
    @JoinColumn(name = "DB102_CON_ID")
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "DB101_EST_ID")
    private Estabelecimento estabelecimento;

}
