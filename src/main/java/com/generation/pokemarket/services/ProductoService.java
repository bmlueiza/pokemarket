package com.generation.pokemarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.pokemarket.models.Producto;
import com.generation.pokemarket.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    //Métodos
    
    //Lista de productos
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    //Obtener producto por id
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    //@Transactional se usa para que todas las operaciones dentro del método se hagan en una sola transacción
    //Esto significa que todas las operaciones se hacen juntas y si una falla, se deshacen todas
    //Esto es útil cuando se hacen varias operaciones que dependen unas de otras
    //Por ejemplo, si se quiere guardar un usuario y un producto, si falla el guardado del producto, no se guarda el usuario
    //Si no se usa @Transactional, se tendría que hacer un rollback manualmente

    //Guardar producto nuevo
    @Transactional
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
}
