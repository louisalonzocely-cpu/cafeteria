package co.edu.sena.adso.cafeteria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import co.edu.sena.adso.cafeteria.model.Plato;
import co.edu.sena.adso.cafeteria.service.MenuService;

@Controller
@RequestMapping("/admin/platos")
public class AdminController {
    private final MenuService menu;

    public AdminController(MenuService menu) {
        this.menu = menu;
    }

    @GetMapping 
    public String lista(Model model) {
        model.addAttribute("platos", menu.todos());
        return "admin";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("plato", new Plato());
        model.addAttribute("accion", "Nuevo plato");
        return "plato-form";
    }

    @PostMapping
    public String guardar(@ModelAttribute("plato") Plato plato) {
        menu.guardar(plato);
        return "redirect:/admin/platos";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("plato", menu.buscar(id));
        model.addAttribute("accion", "Editar plato");
        return "plato-form";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable("id") Long id) {
        menu.eliminar(id);
        return "redirect:/admin/platos";
    }

}
