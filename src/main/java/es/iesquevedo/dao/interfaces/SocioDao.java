package es.iesquevedo.dao.interfaces;

import es.iesquevedo.modelo.Socio;
import java.util.List;
import java.util.Optional;

public interface SocioDao {

    Optional<Socio> findByDni(String dni);

    Socio save(Socio socio);

    List<Socio> findAll();
}