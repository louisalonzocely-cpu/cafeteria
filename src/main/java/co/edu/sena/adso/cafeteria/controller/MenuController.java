package co.edu.sena.adso.cafeteria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.sena.adso.cafeteria.model.Plato;
import co.edu.sena.adso.cafeteria.service.MenuService;

@Controller
public class MenuController {
    
    private final MenuService menu;

    public MenuController(MenuService menu) {
        this.menu = menu;
    }

    @GetMapping("/menu")
    public String verMenu(@RequestParam(name = "tipo", required = false) String tipo, Model model) {
        List<Plato> platos = (tipo == null) ? menu.todos() : menu.porTipo(tipo);
        model.addAttribute("titulo", "Menu del dia");
        model.addAttribute("platos", platos);
        return "menu";
    }

    @GetMapping("/menu/{id}")
    public String verPlato(@PathVariable("id") Long id, Model model) {
        model.addAttribute("plato", menu.buscar(id));
        return "plato";
    }

}
