package com.generation.pokemarket.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera el constructor con todos los atributos, getters y setters, toString y equalsandhashcode
@NoArgsConstructor
@Entity // Indica que la clase es una entidad
@Table(name = "usuarios") // Indica el nombre de la tabla en la base de datos
public class Usuario {

    // Atributos
    @Id // Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el id automáticamente
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    @CreationTimestamp // Genera la fecha de creación automáticamente
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Relaciones

    //En los mappedBy se pone el nombre de la variable que guarda la relación en la otra tabla

    //Relación uno a uno con la tabla perfiles
    @OneToOne(mappedBy = "usuario") //usuario es el nombre de la columna en la tabla perfiles
    private Perfil perfilUsuario; //perfilUsuario es la variable que guarda el perfil del usuario

    //Evita que se cree una relación circular, es decir, que se cree una relación infinita entre las tablas
    @JsonIgnore
    //Relación uno a muchos con la tabla metodos_pago
    //Es decir, un usuario puede tener muchos métodos de pago
    @OneToMany(mappedBy = "usuario") //usuarioMetodoPago es el nombre de la columna en la tabla metodos_pago
    private List<MetodoPago> metodosPagoUsuario; //Esto se usa para guardar los métodos de pago del usuario

    //Evita que se cree una relación circular
    @JsonIgnore
    //Relación uno a muchos con la tabla pedidos
    //Es decir, un usuario puede tener muchos pedidos
    @OneToMany(mappedBy = "usuarioPedido") //usuarioPedido es el nombre de la columna en la tabla pedidos
    private List<Pedido> pedidosUsuario;
}
