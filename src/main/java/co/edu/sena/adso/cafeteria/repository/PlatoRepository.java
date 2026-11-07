package co.edu.sena.adso.cafeteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.adso.cafeteria.model.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
    List<Plato> findByOrdenByNombreAsc();
    List<Plato> findByTipoIgnoreCaseOrderByNombreAsc(String tipo);
}
