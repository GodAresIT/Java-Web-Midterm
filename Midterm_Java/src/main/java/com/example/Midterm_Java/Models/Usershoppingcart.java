package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "usershoppingcart", schema = "midterm_java", catalog = "")
public class Usershoppingcart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "iduser", insertable = false, updatable = false)
    private Integer iduser;
    @Basic
    @Column(name = "idproduct", insertable = false, updatable = false)
    private Integer idproduct;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private Account accountByIduser;
    @ManyToOne
    @JoinColumn(name = "idproduct", referencedColumnName = "id")
    private Product productByIdproduct;

    public Usershoppingcart(Integer iduser, Integer idproduct, Integer quantity) {
        this.iduser = iduser;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Usershoppingcart{" +
                "id=" + id +
                ", iduser=" + iduser +
                ", idproduct=" + idproduct +
                ", quantity=" + quantity +
                '}';
    }
}
