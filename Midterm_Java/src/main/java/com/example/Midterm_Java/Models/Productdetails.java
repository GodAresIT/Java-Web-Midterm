package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@jakarta.persistence.Table(name = "productdetails", schema = "midterm_java", catalog = "")
//@IdClass(ProductdetailsEntityPK.class)
public class Productdetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "id_product")
    private Integer idProduct;


    @Basic
    @Column(name = "price")
    private Long price;

    @Basic
    @Column(name = "brand")
    private String brand;

    @Basic
    @Column(name = "describe_specific")
    private String describeSpecific;

    @Basic
    @Column(name = "images_1")
    private String images_1;

    @Basic
    @Column(name = "images_2")
    private String images_2;

    @Basic
    @Column(name = "images_3")
    private String images_3;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "category")
    private String category;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", insertable = false, updatable = false)
    private Product productByProductId;
    public Productdetails(Integer idProduct, Long price, String brand, String describeSpecific, String images_1, String images_2, String images_3, String name, String category, String type, String color) {
        this.idProduct = idProduct;
        this.price = price;
        this.brand = brand;
        this.describeSpecific = describeSpecific;
        this.images_1 = images_1;
        this.images_2 = images_2;
        this.images_3 = images_3;
        this.name = name;
        this.category = category;
        this.type = type;
        this.color = color;
    }
}
