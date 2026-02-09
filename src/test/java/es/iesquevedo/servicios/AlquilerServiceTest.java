package es.iesquevedo.servicios;

import es.iesquevedo.dao.JsonAlquilerDao;
import es.iesquevedo.dao.JsonPeliculaDao;
import es.iesquevedo.dao.JsonSocioDao;
import es.iesquevedo.modelo.Alquiler;
import es.iesquevedo.modelo.Pelicula;
import es.iesquevedo.modelo.Socio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerServiceTest {

    private AlquilerService service;

    @BeforeEach
    void setUp() {
        String base = System.getProperty("user.dir") + "/testdata"; // carpeta con los JSON _test

        JsonAlquilerDao alquilerDao = new JsonAlquilerDao(base + "/alquileres_test.json");
        JsonPeliculaDao peliculaDao = new JsonPeliculaDao(base + "/peliculas_test.json");
        JsonSocioDao socioDao = new JsonSocioDao(base + "/socios_test.json");

        service = new AlquilerService(alquilerDao, peliculaDao, socioDao, 3);
    }

    @Test
    void listarAlquileresDevuelveTodos() {
        List<Alquiler> alquileres = service.listarAlquileres();
        assertNotNull(alquileres);
        assertFalse(alquileres.isEmpty(), "Debe haber alquileres en el test JSON");

        Alquiler primerAlquiler = alquileres.get(0);
        assertEquals("12345678A", primerAlquiler.getSocio().getDni(), "El DNI del socio debe ser 12345678A");
        assertEquals("Matrix", primerAlquiler.getPelicula().getTitulo(), "El título de la película debe ser Matrix");
    }
}