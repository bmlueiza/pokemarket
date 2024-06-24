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

    //Relación muchos a uno con la tabla de usuarios
    //Es decir, muchos pedidos pueden tener un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id") //usuario_id es el nombre de la columna en la tabla de pedidos
    private Usuario usuarioPedido; //usuarioPedido es la variable que guarda el usuario que hizo el pedido

    //Muchos pedidos pueden tener un método de pago
    @ManyToOne
    @JoinColumn(name = "metodo_id") //metodo_pago_id es el nombre de la columna en la tabla de pedidos
    private MetodoPago metodoPago; //metodoPago es la variable que guarda el método de pago del pedido
}
