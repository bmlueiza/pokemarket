package com.generation.pokemarket.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
