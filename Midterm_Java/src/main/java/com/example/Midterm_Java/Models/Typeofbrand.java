package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "typeofbrand", schema = "midterm_java", catalog = "")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Typeofbrand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "idbrand", insertable = false, updatable = false)
    private Integer idbrand;
    @ManyToOne
    @JoinColumn(name = "idbrand", referencedColumnName = "id")
    private Brand brandByIdbrand;

    public Typeofbrand(String name, Integer idbrand) {
        this.name = name;
        this.idbrand = idbrand;
    }
}
