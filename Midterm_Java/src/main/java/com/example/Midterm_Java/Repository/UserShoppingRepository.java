package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Models.Usershoppingcart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserShoppingRepository extends JpaRepository<Usershoppingcart, Integer> {
    @Query("SELECT u FROM Usershoppingcart u WHERE u.iduser = :iduser")
    List<Usershoppingcart> findAllProductOfUser(@Param("iduser") Integer iduser);

    @Query("SELECT p FROM Product  p where p.id = :id")
    Product findProductById(@Param("id") Integer id);
//    @Query("DELETE FROM Usershoppingcart u where u.iduser = :iduser and u.idproduct = :idproduct")
//    void deleteProductWasBuyOfUser(@Param("iduser") Integer iduser, @Param("idproduct") Integer idproduct);

    @Query("SELECT u.id FROM Usershoppingcart u where u.iduser = :iduser and u.idproduct = :idproduct")
    Integer getIdOfUserShopping(@Param("iduser") Integer iduser,  @Param("idproduct") Integer idproduct);

    @Query("SELECT u FROM Usershoppingcart u where u.iduser = :iduser and u.idproduct = :idproduct")
    Usershoppingcart checkProductIsPresent(@Param("iduser") Integer iduser,  @Param("idproduct") Integer idproduct);

    @Modifying
    @Transactional
    @Query("UPDATE Usershoppingcart u set u.quantity = u.quantity + 1 where u.iduser = :iduser and u.idproduct = :idproduct")
    void updateQuantity(@Param("iduser") Integer iduser,  @Param("idproduct") Integer idproduct);

    @Modifying
    @Transactional
    @Query(value = "insert into Usershoppingcart(iduser, idproduct, quantity) values(:iduser, :idproduct, :quantity)", nativeQuery = true)
    void insertProductIntoShoppingCart(@Param("iduser") Integer iduser, @Param("idproduct") Integer idproduct,@Param("quantity") Integer quantity );

    @Modifying
    @Query("delete from Usershoppingcart u where u.idproduct = :idproduct")
    void deleteProductInShoppingCart(@Param("idproduct") Integer idproduct);
}
