package com.example.Midterm_Java.Services;

import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> getProductsByBrand(String brand){
        return productRepository.getProductsByBrand(brand);
    }

    public boolean updateImagesPathOfProduct(String images, Integer id){
        try {
            productRepository.updateImagesPathOfProduct(images, id);
            return true;
        }catch (Exception e){}
        return false;
    }

}
