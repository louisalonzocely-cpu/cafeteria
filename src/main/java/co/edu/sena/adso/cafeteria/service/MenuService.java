
package co.edu.sena.adso.cafeteria.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.sena.adso.cafeteria.model.Plato;
import co.edu.sena.adso.cafeteria.repository.PlatoRepository;

@Service
public class MenuService {

    private final PlatoRepository repo;
    
    public MenuService(PlatoRepository repo) {
        this.repo = repo;
    }

    //Metodo para lista todos los platos
    public List<Plato> todos() {
        return repo.findByOrderByNombreAsc();
    }

    //Metodo para filtrar por tipo
    public List<Plato> porTipo(String tipo) {
        return repo.findByTipoIgnoreCaseOrderByNombreAsc(tipo);
    }

    //Metodo para buscar
    public Plato buscar(Long id) {
        return repo.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el plato" + id));
    }

    public Plato guardar(Plato plato) {
        plato.setTipo(plato.getTipo().toLowerCase());
        return repo.save(plato);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el plato " + id);
        }
        repo.deleteById(id);
    }

}
