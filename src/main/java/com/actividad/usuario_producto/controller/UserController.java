package com.actividad.usuario_producto.controller;

import com.actividad.usuario_producto.model.User;
import com.actividad.usuario_producto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Display all users
    @GetMapping("/all")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/List";  // Redirige a la plantilla "List.html"
    }

    // Display the form to create a new user (Register page)
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());  // Añade un nuevo objeto User vacío
        return "users/UserRegister";  // Redirige a la plantilla "UserRegister.html"
    }

    @GetMapping("/userSave")
    public String RegisterForm(Model model) {
        model.addAttribute("user", new User());  // Añade un nuevo objeto User vacío
        return "users/UserSave";  // Redirige a la plantilla "UserSave.html"
    }

    // Save a new user or update an existing one
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);  // Guarda el usuario en la base de datos
        return "users/Login";  // Redirige a la lista de usuarios después de guardar
    }

    @PostMapping("/userRegister")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.save(user);  // Guarda el usuario en la base de datos
        return "redirect:/user/all";  // Redirige a la lista de usuarios después de guardar
    }

    // Delete a user by ID using @PathVariable
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);  // Elimina el usuario por su ID
        return "redirect:/user/all";  // Redirige a la lista de usuarios después de eliminar
    }
}

