package com.generation.pokemarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.services.UsuarioService;

//En los controladores se definen las rutas que se van a usar en la API
//Se usan las anotaciones @RestController y @RequestMapping
@RestController //Indica a Spring que esta clase es un bean de controlador
@RequestMapping("/api/usuarios") //Indica la ruta base de la API. Esta ruta se concatena con las rutas de los Métodos
//Ejemplo: Si la ruta base es /api/usuarios y un método tiene la ruta /nuevo, la ruta completa sería /api/usuarios/nuevo
//Ejecutar la aplicación y abrir http://localhost:8080/api/usuarios en el navegador
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    //Métodos de la API

    //Método para obtener todos los usuarios
    //Se usa la anotación @GetMapping y se le pasa la ruta
    //En este caso, la ruta es /todos
    //La ruta completa sería /api/usuarios/todos
    //Se regresa la lista de usuarios que se obtiene con el método getUsuarios de UsuarioService
    //Se regresa la lista de usuarios en formato JSON
    //Ejecutar la aplicación y abrir http://localhost:8080/api/usuarios/todos en el navegador
    //Se debe ver la lista de usuarios en formato JSON
    @GetMapping("/todos")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    } 

    //Método para obtener un usuario por su id
    @GetMapping("/{id}") //Con {id} se indica que se va a recibir un parámetro en la ruta
    public Usuario getUsuario(Long id) {
        return usuarioService.getUsuario(id);
    }

    //Método para obtener un usuario por su nombre
    @GetMapping("/{nombre}")
    public Usuario getUsuarioByName(@PathVariable String nombre) { //Con @PathVariable se indica que el parámetro se recibe de la ruta. Si no se pone, se recibe de la petición, por ejemplo, de un formulario
        return usuarioService.getUsuarioByName(nombre);
    }
}
