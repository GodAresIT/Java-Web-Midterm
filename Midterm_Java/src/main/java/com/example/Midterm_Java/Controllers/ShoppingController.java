package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Models.Account;
import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Models.Usershoppingcart;
import com.example.Midterm_Java.Repository.AccountRepository;
import com.example.Midterm_Java.Services.ProductService;
import com.example.Midterm_Java.Services.UserShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class ShoppingController {
    @Autowired
    UserShoppingService userShopping;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductService productService;

    // Method to get all products in shopping-cart of user
    @RequestMapping("/shoppingcart/{userid}")
    public String shoppingcart(@PathVariable("userid") Integer iduser, Model model){
        List<Usershoppingcart> usershoppingcartList = userShopping.findAllProductShoppingOfUser(iduser);
        List<Product> productList = new ArrayList<Product>();
        for(Usershoppingcart usershoppingcart : usershoppingcartList){
            Product product = userShopping.findProductById(usershoppingcart.getIdproduct());
            productList.add(product);
        }

        model.addAttribute("UserShopping", usershoppingcartList);
        model.addAttribute("Account", iduser);
        model.addAttribute("ProductOfUser", productList);
        return "shopping-cart";
    }

    // Method to return user homepage
    @RequestMapping("/homeuser/{id}")
    public String homeuser(@PathVariable("id") Integer id, Model model){
        Optional<Account> user = accountRepository.findById(id);
        List<Product> productList = productService.getAllProduct();

        model.addAttribute("Account", user.get());
        model.addAttribute("products", productList);
        return "userpage";
    }

    // Method to get product the user click to buy
    @GetMapping("/buyProductSuccess/{idproduct}/user/{iduser}")
    public RedirectView deleteProductWasBuy(@PathVariable("idproduct") Integer idproduct, @PathVariable("iduser") Integer iduser, RedirectAttributes redirectAttributes){
        try{
            userShopping.deleteProductOfUser(iduser, idproduct);
            redirectAttributes.addAttribute("userid", iduser); // add the attribute into the ủl
            return new RedirectView("/user/shoppingcart/{userid}");
        }catch (Exception e){}
        return new RedirectView("https://www.sorryapp.com/error-pages/");
    }

    @RequestMapping("/deleteProduct/{idproduct}/user/{iduser}")
    public RedirectView deleteProductByClick(@PathVariable("idproduct") Integer idproduct, @PathVariable("iduser") Integer iduser, RedirectAttributes redirectAttributes){
        try {
            userShopping.deleteProductOfUser(iduser, idproduct);
            redirectAttributes.addAttribute("userid", iduser); // add the attribute into the ủl
            return new RedirectView("/user/shoppingcart/{userid}");
        }catch (Exception e){}
        return new RedirectView("https://www.sorryapp.com/error-pages/");
    }
}
