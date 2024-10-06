package com.actividad.usuario_producto.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String idn;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    public User() {
        super();
    }

    public User(Long id, String username, String idn, String name, String lastName, String address, String password, String email) {
        this.id = id;
        this.username = username;
        this.idn = idn;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
    }

    public User(String username, String idn, String name, String lastName, String address, String password, String email) {
        this.username = username;
        this.idn = idn;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

