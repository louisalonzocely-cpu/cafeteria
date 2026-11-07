package co.edu.sena.adso.cafeteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String verContacto(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "contacto";
    }

    @PostMapping("/contacto")
    public String enviarContacto(
            @RequestParam("nombre") String nombre,
            @RequestParam("correo") String correo,
            @RequestParam("asunto") String asunto,
            Model model) {
        model.addAttribute("titulo", "Contacto");
        model.addAttribute("nombre", nombre);
        model.addAttribute("correo", correo);
        model.addAttribute("asunto", asunto);
        model.addAttribute("enviado", true);
        return "contacto";
    }
}
