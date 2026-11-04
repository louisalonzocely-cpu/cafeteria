package co.edu.sena.adso.cafeteria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.adso.cafeteria.model.Plato;
import co.edu.sena.adso.cafeteria.service.MenuService;

@RestController             
@RequestMapping("/api/menu")
public class MenuApiController {

    private final MenuService menu;   

    public MenuApiController(MenuService menu) {
        this.menu = menu;
    }

    @GetMapping                 
    public List<Plato> todos() {
        return menu.todos();
    }

    @GetMapping("/{id}")        
    public Plato uno(@PathVariable("id") Long id) {
        return menu.buscar(id);
    }
}