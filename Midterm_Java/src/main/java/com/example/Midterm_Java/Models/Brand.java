package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "brand", schema = "midterm_java", catalog = "")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Brand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "brandByIdbrand")
    private Collection<Typeofbrand> typeofbrandsById;


    public Brand(String name) {
        this.name = name;
    }
}
