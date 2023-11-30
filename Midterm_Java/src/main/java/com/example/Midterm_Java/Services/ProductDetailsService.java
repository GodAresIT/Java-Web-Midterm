package com.example.Midterm_Java.Services;


import com.example.Midterm_Java.Models.Productdetails;
import com.example.Midterm_Java.Repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailsService {
    @Autowired
    ProductDetailsRepository productDetailsRepository;
    public Productdetails findDetailsProduct(Integer id){
        return productDetailsRepository.findDetailsProduct(id);
    }

    public List<Integer> findProductByFilter(String condition){
        List<Integer> list = new ArrayList<Integer>();
        try{
            List<Productdetails> productdetailsList = productDetailsRepository.getProductByFilter(condition);

            for(Productdetails productdetails : productdetailsList){

                list.add(productdetails.getIdProduct());
            }
            return list;
        }catch (Exception e){}
        return null;
    }

    public List<Integer> findProductByFilter_JDBC(String condition) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Midterm_Java";
        Connection conn = DriverManager.getConnection(url, "root", "");
        String querySelect = "SELECT * FROM productdetails WHERE " + condition;

        Statement st = null;
        List<Integer> list = new ArrayList<Integer>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySelect);
            while (rs.next()){
                list.add(rs.getInt("id_product"));
            }
            return  list;
        }catch (Exception e){}
        return null;
    }

    public List<Integer> findProductByKeySearch(String keySearch){
        List<Integer> list = new ArrayList<Integer>();
        try{
            List<Productdetails> productdetailsList = productDetailsRepository.getProductByKeySeach(keySearch);

            for(Productdetails productdetails : productdetailsList){
                list.add(productdetails.getIdProduct());
            }
            return list;
        }catch (Exception e){}
        return null;
    }
}
