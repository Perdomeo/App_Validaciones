package com.actividad.usuario_producto.service;

import com.actividad.usuario_producto.model.User;
import com.actividad.usuario_producto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Find all users in the database
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Save or update a user in the database
    public void save(User user) {
        userRepository.save(user);
    }

    // Delete a user by their ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
