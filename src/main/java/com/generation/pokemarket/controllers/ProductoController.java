package com.generation.pokemarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.pokemarket.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    //Métodos de la API

    //Método para obtener todos los productos
    @GetMapping("/todos")
    //ResponseEntity<?> se usa para regresar una respuesta HTTP. El signo de interrogación indica que puede regresar cualquier tipo de dato
    //En este caso, se regresa una lista de productos
    public ResponseEntity<?> getProductos() {
        return new ResponseEntity<>(productoService.getProductos(), HttpStatus.OK); //Se regresa la lista de productos en formato JSON
        //new ResponseEntity<>(productoService.getProductos(), HttpStatus.OK) regresa la lista de productos en formato JSON con un estatus 200
    }

    //Método para obtener un producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProducto(Long id) {
        return new ResponseEntity<>(productoService.getProducto(id), HttpStatus.OK); //Se regresa el producto en formato JSON con un estatus 200
    }
}
