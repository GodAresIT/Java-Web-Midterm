package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "category", schema = "midterm_java", catalog = "")
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "")
//    private Collection<Productdetails> productdetailsById;
}
