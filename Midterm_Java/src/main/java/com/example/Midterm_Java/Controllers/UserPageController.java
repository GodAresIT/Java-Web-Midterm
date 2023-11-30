package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Models.Account;
import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Models.Usershoppingcart;
import com.example.Midterm_Java.Repository.AccountRepository;
import com.example.Midterm_Java.Repository.UserShoppingRepository;
import com.example.Midterm_Java.Services.AccountService;
import com.example.Midterm_Java.Services.ProductService;
import com.example.Midterm_Java.Services.UserShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserPageController {
    @Autowired
    ProductService productService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserShoppingRepository userShoppingRepository;
    @Autowired
    UserShoppingService userShoppingService;
    @GetMapping("homeuser/{iduser}")
    public String homeuser(@PathVariable("iduser") Integer iduser, Model model){

        List<Product> productList = productService.getAllProduct();
        Optional<Account> user = accountRepository.findById(iduser);
        model.addAttribute("products", productList);
        model.addAttribute("Account", user.get());
        return "userpage";
    }
    @RequestMapping("addproduct-to-shopping-cart/{iduser}/{idproduct}")
    public RedirectView addProductIntoShoppingCart(@PathVariable("iduser") Integer iduser, @PathVariable("idproduct") Integer idproduct, RedirectAttributes redirectAttributes){
        // Check product is present in shopping cart then up the quantity++
        // If not then add product into shopping-cart
        Usershoppingcart usershoppingcart  = userShoppingService.checkIfProductIsExist(iduser, idproduct);
        if(usershoppingcart !=null){
            //update quantity
            userShoppingService.updateQuantityProductShoppingcart(iduser, idproduct);
        }else{

            //System.out.println(userShoppingService.insertProductToShoppingCart(iduser, idproduct, 1));

            //userShoppingRepository.save(new Usershoppingcart(iduser, idproduct, 1)); it save null user and id-product to database
            userShoppingService.insertProductToShoppingCart(iduser, idproduct, 1);
        }
        redirectAttributes.addAttribute("id", idproduct);
        redirectAttributes.addAttribute("iduser", iduser);
        return new RedirectView("/details/product/{id}/{iduser}");
    }
}
