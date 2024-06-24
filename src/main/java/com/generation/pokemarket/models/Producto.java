package com.generation.pokemarket.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombreProducto;
    @Column(name = "stock")
    private Integer stockProducto;
    @Column(name = "precio")
    private Double precioProducto;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    //Relación muchos a muchos con la taba pedidos, es decir, muchos productos pueden estar en muchos pedidos
    //Se crea una tabla intermedia para guardar los id de los productos y los id de los pedidos
    @ManyToMany
    @JoinTable(name = "productos_pedidos", //Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "producto_id"), //Nombre de la columna en la tabla intermedia que guarda el id del producto
        inverseJoinColumns = @JoinColumn(name = "pedido_id")) //Nombre de la columna en la tabla intermedia que guarda el id del pedido
    private List<Pedido> pedidos; //pedidos es la variable que guarda los pedidos en los que está el producto
}
