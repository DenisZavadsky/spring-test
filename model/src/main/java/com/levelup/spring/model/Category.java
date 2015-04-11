package com.levelup.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by denis_zavadsky on 4/11/15.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    Long id;
    String name;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID", referencedColumnName = "ID")
    List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
