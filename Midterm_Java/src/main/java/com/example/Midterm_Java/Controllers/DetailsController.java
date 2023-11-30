package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Models.Productdetails;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import com.example.Midterm_Java.Services.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.View;


@Controller
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    ProductDetailsService productDetailsService;

    @GetMapping("/product/{id}/{iduser}")
    public String detailsProduct(@PathVariable("id") Integer id, @PathVariable("iduser") Integer iduser, Model model){
        Productdetails productdetails = productDetailsService.findDetailsProduct(id);
        model.addAttribute("productdetails", productdetails);
        model.addAttribute("iduser", iduser);

        return "detailsproduct";
    }
}
