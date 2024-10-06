package com.actividad.usuario_producto.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long sku;

    @Column
    private String name;

    @Column
    private float price;

    @Column
    private String brand;

    @Column
    private String store;

    public Product() {
        super();
    }

    public Product(Long id, Long sku, String name, float price, String brand, String store) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.store = store;
    }

    public Product(Long sku, String name, float price, String brand, String store) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}

