package com.example.Midterm_Java.Services;

import com.example.Midterm_Java.Repository.ProductDetailsRepository;
import com.example.Midterm_Java.Repository.ProductRepository;
import com.example.Midterm_Java.Repository.UserShoppingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;
    @Autowired
    UserShoppingRepository userShoppingRepository;
    @Transactional
    public boolean deleteProductDetailsByIdProduct(Integer idproduct){
        try{
            productDetailsRepository.deleteProductdetailsByIdProduct(idproduct);
            return true;
        }catch (Exception e){}
        return false;
    }

    @Transactional
    public boolean deleteProductInShoppingCartByIdProduct(Integer idproduct){
        try{
            userShoppingRepository.deleteProductInShoppingCart(idproduct);
            return true;
        }catch (Exception e){}
        return false;
    }

    public boolean updatePathOf3ImagesInProductDetails(String images1, String images2, String images3, Integer id){
        try{
            productDetailsRepository.updatePathOf3Images(images1, images2, images3, id);
            return true;
        }catch (Exception e){}
        return false;
    }
}
