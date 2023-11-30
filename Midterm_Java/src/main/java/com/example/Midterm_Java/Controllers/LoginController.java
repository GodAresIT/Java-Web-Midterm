package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Models.Account;
import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Repository.AccountRepository;
import com.example.Midterm_Java.Services.AccountService;
import com.example.Midterm_Java.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("logindone")
    public RedirectView successLogin(@RequestParam("username") String accountname, @RequestParam("pass") String pass, RedirectAttributes redirectAttributes ,HttpSession session){

        try{
            Account user=  accountService.findUserAccount(accountname,pass);

            if(user.getRole().equals("admin")){
                
                redirectAttributes.addAttribute("idadmin", user.getId());
                return new RedirectView("/adminpage/{idadmin}");
            }else if(user.getRole().equals("user")){

                redirectAttributes.addAttribute("iduser", user.getId());
                //session.setAttribute("iduser", user.getId());
                return new RedirectView("homeuser/{iduser}");
            }
        }catch (Exception e){
            e.getMessage();
        }
        return new RedirectView("/login");
    }




    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping("register/save")
    public String successRegister(@RequestParam("username") String username, @RequestParam("accountname") String accountname, @RequestParam("password") String pass, Model model){
        Account account = new Account(accountname, pass, "user", username);
        if(accountService.saveAccount(account)){
            return "redirect:/login";
        }
        return "register";
    }
}
