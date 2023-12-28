package com.hipizza.demo.domain;

import com.hipizza.demo.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Status")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;
}
