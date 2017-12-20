package com.kurotkin.manufacturer_data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private Set<Product> products = new HashSet<Product>();

    public Manufacturer() {
    }

    public Manufacturer(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Manufacturer withID(Long id) {
        this.id = id;
        return this;
    }

    public Manufacturer withName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
