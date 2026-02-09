package es.iesquevedo.dao.interfaces;

import es.iesquevedo.modelo.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaDao {

    Optional<Pelicula> findAvailableByTitulo(String titulo);

    Pelicula save(Pelicula pelicula);

    List<Pelicula> findAll();
}