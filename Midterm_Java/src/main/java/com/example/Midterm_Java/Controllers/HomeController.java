package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Services.ProductDetailsService;
import com.example.Midterm_Java.Services.ProductService;

import org.springframework.ui.Model;
import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

//@CrossOrigin("*")
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;
    @Autowired
    ProductDetailsService productDetailsService;

    @GetMapping("home")
    private String showAllProduct(ModelMap model){
        //data.insertData();
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("products", productList);
        return "index";
    }
    @GetMapping("home/filter")
    private String showFilterProducts(Model model, @RequestParam("brand") String brand, @RequestParam("category") String category,
                                      @RequestParam("color") String color, @RequestParam("price") String price) throws SQLException {
//        System.out.println(brand);
//        System.out.println(category);
//        System.out.println(color);
//        System.out.println(price);

        LinkedHashMap<String, String> listFilter = new LinkedHashMap<String, String>();
        listFilter.put("brand", brand);
        listFilter.put("category", category);
        listFilter.put("color", color);
        listFilter.put("price", price);
        Set<String> key = listFilter.keySet();
//        System.out.println("key list: " + key);
        List<String> keyRemove = new ArrayList<String>();
        for(String s : key){
            if(listFilter.get(s).equals("choose")){
                //listFilter.remove(s);
                keyRemove.add(s);
            }
        }
        for(String s : keyRemove){
            listFilter.remove(s);
        }
//        System.out.println("List after remove key: " + listFilter.toString());
        String query = "";
        int count = 0;

        for(String s : key) {

            if(count<listFilter.size()-1){
                query = query  +  s + " = '" + listFilter.get(s) + "' and ";
            }else{
                if(s.equals("price")){
                    query = query  +  s + " <= " + listFilter.get(s) ;
                }else{
                    query = query  +  s + " = '" + listFilter.get(s) + "'";
                }

            }
            count++;
        }
//        System.out.println(query);

        //List<Integer> listProduct = productDetailsService.findProductByFilter(query);

        List<Integer> listProduct = productDetailsService.findProductByFilter_JDBC(query);




        List<Product> productList = new ArrayList<Product>();
        if(listProduct != null){
            for(Integer id : listProduct){
                productList.add(productService.getProductById(id).get());
            }

        }
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("home/search")
    private String showSearchProducts(Model model, @RequestParam("searchKey") String searchKey){
        searchKey = "%" + searchKey + "%";
        List<Integer> listIdProduct = productDetailsService.findProductByKeySearch(searchKey);
        List<Product> productList = new ArrayList<Product>();

        if(listIdProduct != null){
            for(Integer id: listIdProduct){
                productList.add(productService.getProductById(id).get());
            }
        }

        model.addAttribute("products", productList);
        return "index";
    }



    //Filter if one of them is default value then will changed it to null string

}
