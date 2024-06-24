package com.generation.pokemarket.models;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto_total")
    private Double montoPedido;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @CreationTimestamp
    @Column(name = "fecha_pedido")
    private String fechaPedido;
}
