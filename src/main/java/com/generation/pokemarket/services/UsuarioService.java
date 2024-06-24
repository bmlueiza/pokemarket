package com.generation.pokemarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.repositories.UsuarioRepository;

//En los servicios se pueden hacer las operaciones que se necesiten con los datos de la base de datos
//Se pueden hacer operaciones más complejas que las que se pueden hacer con los repositorios
//Se pueden hacer operaciones con varios modelos a la vez
@Service
public class UsuarioService {
    
    //Se inyecta el repositorio de usuarios
    //Se usa la anotación @Autowired para que Spring inyecte el repositorio automáticamente
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //Métodos
    
    //No se necesita hacer métodos para guardar, actualizar o eliminar usuarios porque JpaRepository ya tiene esos métodos
    //No es necesario usar todos los métodos de JpaRepository, solo los que se necesiten

    //Obtener usuario por id
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null); //Se usa orElse(null) para que regrese null si no encuentra el usuario. Si no se pone, regresa un error
    }

    //Obtener usuario por nombre
    public Usuario getUsuarioByName(String nombre) {
        return usuarioRepository.findByNombre(nombre); //Aquí no se necesita orElse(null) porque findByNombre ya regresa null si no encuentra el usuario
    }

    //Obtener lista de usuarios
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll(); //findAll regresa una lista con todos los usuarios
    }
}
