package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Filter by type, name, price, color
    @Query("SELECT p FROM Productdetails p WHERE p.brand LIKE %?1%")
    List<Product> getProductsByBrand(String brand);

    @Modifying
    @Transactional
    @Query(value = "update Product p set p.images = :images where p.id = :idproduct")
    Void updateImagesPathOfProduct(@Param("images") String images, @Param("idproduct") Integer idproduct);
}