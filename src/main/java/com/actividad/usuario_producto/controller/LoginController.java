package com.actividad.usuario_producto.controller;

import com.actividad.usuario_producto.model.User;
import com.actividad.usuario_producto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    // Mostrar la página de login
    @GetMapping
    public String loginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password. Please try again.");
        }
        return "users/Login";  // Muestra la plantilla de login
    }

    // Procesar el formulario de login
    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        // Buscar usuario por nombre de usuario
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Si las credenciales son correctas, redirige a la lista de usuarios
            return "redirect:/user/all";
        } else {
            // Si el login falla, redirige a la página de login con un parámetro de error
            return "redirect:/login?error=true";
        }
    }
}
