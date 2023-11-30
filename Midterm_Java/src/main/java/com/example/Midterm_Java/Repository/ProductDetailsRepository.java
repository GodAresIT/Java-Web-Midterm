package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Productdetails;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductDetailsRepository extends JpaRepository<Productdetails, Integer> {
    @Query("SELECT p FROM Productdetails p WHERE p.idProduct = :idproduct")
    Productdetails findDetailsProduct(@Param("idproduct") Integer id);

    @Query( value = "SELECT u from Productdetails u WHERE u.brand = ?1")
    List<Productdetails> getProductByFilter(String condition);

    @Query(value = "SELECT p from Productdetails p WHERE p.name like  :keySearch")
    List<Productdetails> getProductByKeySeach(@Param("keySearch") String keysearch);

    @Modifying
    @Query(value = "delete from Productdetails p where p.idProduct = :idproduct")
    void deleteProductdetailsByIdProduct(@Param("idproduct") Integer idproduct);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Productdetails  p set p.images_1 = ?1, p.images_2 = ?2, p.images_3 = ?3 where p.id = ?4")
    void updatePathOf3Images(String images1, String images2, String images3, Integer id);
}
