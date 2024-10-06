package com.actividad.usuario_producto.controller;

import com.actividad.usuario_producto.model.Product;
import com.actividad.usuario_producto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Mostrar la lista de productos
    @GetMapping("/all")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/List";  // Redirige a la vista "ProductList.html"
    }

    // Mostrar el formulario para registrar un nuevo producto
    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/ProductRegister";  // Redirige a la vista del formulario de productos
    }

    // Guardar un nuevo producto
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product/all";  // Redirige de nuevo a la lista de productos después de guardar
    }

    // Eliminar un producto por ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product/all";  // Redirige de nuevo a la lista de productos después de eliminar
    }
}
