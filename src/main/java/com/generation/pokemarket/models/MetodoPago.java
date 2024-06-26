package com.generation.pokemarket.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombreMetodo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Un método de pago puede tener muchos pedidos
    @OneToMany(mappedBy = "metodoPago")
    private List<Pedido> pedidos;

    // Constructor sin argumentos
    public MetodoPago() {
    }

    // Constructor con argumentos
    public MetodoPago(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    // Getters y Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return this.nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }
}
