package com.actividad.usuario_producto.service;

import com.actividad.usuario_producto.model.Product;
import com.actividad.usuario_producto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Find all products in the database
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Save or update a product in the database
    public void save(Product product) {
        productRepository.save(product);
    }

    // Delete a product by their ID
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

