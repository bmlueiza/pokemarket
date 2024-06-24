package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "perfiles")
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fotoPerfil;

    // Relación uno a uno con la tabla de usuarios
    @OneToOne
    @JoinColumn(name = "usuario_id") // Nombre de la columna en la tabla de perfiles
    private Usuario usuario; //usuario es la variable que guarda el usuario al que pertenece el perfil
}
