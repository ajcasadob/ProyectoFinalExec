package com.salesianostriana.dam.CasadoBayonAntonioJesus.repository;

import com.salesianostriana.dam.CasadoBayonAntonioJesus.model.Producto;
import com.salesianostriana.dam.CasadoBayonAntonioJesus.tipos.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT p FROM Producto p ORDER BY p.popularidad DESC")
    List<Producto> obtenerMejorValorados();

    List<Producto> findTop2ByOrderByFechaDesc();

    @Query("SELECT p FROM Producto p WHERE p.popularidad < 5 ")
    List<Producto> findByPopularidadMenor();

    @Query("SELECT p FROM Producto p ORDER BY p.precioOriginal DESC")
    List<Producto> findByPrecioDesc();

    @Query("SELECT  p FROM Producto p ORDER BY p.precioOriginal ASC")
    List<Producto> findByPrecioAsc();

    @Query("SELECT p FROM Producto p ORDER BY p.nombre ASC")
    List<Producto> findByNombreAsc();

    @Query("SELECT p FROM Producto p ORDER BY p.fecha DESC")
    List<Producto> findByFechaDesc();


    @Query("SELECT p FROM Producto p ORDER BY p.popularidad DESC")
    List<Producto> findByPopularidadDesc();

    @Query("SELECT  p FROM Producto p ORDER BY p.precio ASC")
    List<Producto> findByPrecioAsc2();
}