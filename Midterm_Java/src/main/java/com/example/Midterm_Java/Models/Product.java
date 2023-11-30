package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@jakarta.persistence.Table(name = "product", schema = "midterm_java", catalog = "")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private Long price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "images")
    private String images;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productByIdproduct")
    private Collection<Usershoppingcart> usershoppingcartsById;

    @OneToOne(mappedBy = "productByProductId")
    private Productdetails productdetailsById;

    public Product(Long price, String description, String images, String name) {
        this.price = price;
        this.description = description;
        this.images = images;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
