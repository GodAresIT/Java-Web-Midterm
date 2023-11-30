package com.example.Midterm_Java.Services;

import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Models.Usershoppingcart;
import com.example.Midterm_Java.Repository.UserShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShoppingService {
    @Autowired
    UserShoppingRepository userShoppingRepository;
    public List<Usershoppingcart> findAllProductShoppingOfUser(Integer iduser){
        return userShoppingRepository.findAllProductOfUser(iduser);
    }
    public Product findProductById(Integer id){
        return userShoppingRepository.findProductById(id);
    }
    public boolean deleteProductOfUser(Integer iduser, Integer idproduct){
        try{
            Integer id = userShoppingRepository.getIdOfUserShopping(iduser, idproduct);
            userShoppingRepository.deleteById(id);
            //userShoppingRepository.deleteProductWasBuyOfUser(iduser, idproduct);
            return true;
        }catch (Exception e){}
        return false;
    }

    public Usershoppingcart checkIfProductIsExist(Integer iduser, Integer idproduct){
        try{
            Usershoppingcart usershoppingcart = userShoppingRepository.checkProductIsPresent(iduser, idproduct);
            return usershoppingcart;
        }catch (Exception e){}
        return null;
    }

    public boolean updateQuantityProductShoppingcart(Integer iduser, Integer idproduct){
        try {
            userShoppingRepository.updateQuantity(iduser, idproduct);
            return true;
        }catch (Exception e){}
        return  false;
    }

    public boolean insertProductToShoppingCart(Integer iduser, Integer idproduct, Integer quantity){
        try {
            userShoppingRepository.insertProductIntoShoppingCart(iduser, idproduct, quantity);
            return true;
        }catch (Exception e){}
        return  false;
    }


}
