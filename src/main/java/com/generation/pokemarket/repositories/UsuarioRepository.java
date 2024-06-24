package com.generation.pokemarket.repositories;

import com.generation.pokemarket.models.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//En los repositorios se definen los métodos que se pueden usar para interactuar con la base de datos
//Se extiende de JpaRepository y se le pasa el modelo con el que se va a trabajar y el tipo de dato de la llave primaria
@Repository //Indica a Spring que esta clase es un bean de repositorio
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Métodos con JpaRepository

    //JpaRepository ya tiene métodos predefinidos como save, findAll, findById, delete, etc.
    
    //Método para buscar un usuario por su nombre
    Usuario findByNombre(String nombre);

    //Método para buscar un usuario por su correo
    Usuario findByCorreo(String correo);

    //Métodos con JPQL

    //Si se necesita hacer una consulta más compleja, se puede hacer con JPQL
    //JPQL es un lenguaje de consultas orientado a objetos
    //Se usa la anotación @Query y se le pasa la consulta
    //En la consulta se usa el nombre de la clase y de las variables, no el nombre de las tablas y columnas
    //Se pueden usar parámetros con ? y se pasan en el mismo orden en el que se usan
    //Se pueden usar parámetros con : y se pasan con @Param
    //Se puede usar el nombre de la tabla y las columnas si se usa nativeQuery = true

    //Método para buscar un usuario por su nombre y apellido
    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.apellido = ?2")
    Usuario findByNombreAndApellido(String nombre, String apellido);

    //Método para buscar un usuario por su nombre y apellido con @Param
    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.apellido = :apellido")
    Usuario findByNombreAndApellidoParam(@Param("nombre") String nombre, @Param("apellido") String apellido);

    //Método para buscar un usuario con un nombre que contenga una cadena
    //Ejemplo: Si se pasa "a" como parámetro, se buscarán los usuarios que tengan una "a" en su nombre
    //Con %parametro% se busca la cadena en cualquier parte del nombre
    @Query(value = "SELECT * FROM usuarios u WHERE u.nombre LIKE %:nombre%", nativeQuery = true)
    List<Usuario> findByNombreLike(@Param("nombre") String nombre); //Se usa @Param para pasar el parámetro y se le asigna el nombre que se usó en la consulta. En este caso, :nombre. String nombre es el parámetro que se va a pasar
}