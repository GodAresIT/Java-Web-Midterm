package com.example.Midterm_Java.Controllers;

import com.example.Midterm_Java.Models.Account;
import com.example.Midterm_Java.Models.Product;
import com.example.Midterm_Java.Models.Productdetails;
import com.example.Midterm_Java.Repository.AccountRepository;
import com.example.Midterm_Java.Repository.ProductDetailsRepository;
import com.example.Midterm_Java.Repository.ProductRepository;
import com.example.Midterm_Java.Services.AdminService;
import com.example.Midterm_Java.Services.FileUploadUtils;
import com.example.Midterm_Java.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.util.StringUtils;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    ProductService productService;

    @RequestMapping("adminpage/{idadmin}")
    private String adminPage(@PathVariable("idadmin") Integer idadmin, Model model){
        Optional<Account> account = accountRepository.findById(idadmin);
        model.addAttribute("Account", account.get());

        List<Product> productList = productService.getAllProduct();
        model.addAttribute("products", productList);
        return "adminpage";
    }
    @GetMapping("adminpage/{idadmin}/delete/{idproduct}")
    private RedirectView deleteProduct(@PathVariable("idproduct") Integer idproduct, @PathVariable("idadmin") Integer idadmin, RedirectAttributes redirectAttributes){
        try{
            adminService.deleteProductInShoppingCartByIdProduct(idproduct);

            adminService.deleteProductDetailsByIdProduct(idproduct);

            productRepository.deleteById(idproduct);
            // delete in productdetails and shopping-cart
            redirectAttributes.addAttribute("idadmin", idadmin);
            return new RedirectView("/adminpage/{idadmin}");
        }catch (Exception e){}
        return new RedirectView("https://www.sorryapp.com/error-pages/");
    }

    @RequestMapping(value = "adminpage/{idadmin}/insert", method = RequestMethod.POST)
    private RedirectView insertProduct(Model model, @RequestParam("brand") String brand, @RequestParam("category") String category,
                                       @RequestParam("type")String type, @RequestParam("name") String name,
                                       @RequestParam("description") String description, @RequestParam("describe_specific") String describe_specific,
                                       @RequestParam("color")String color, @RequestParam("price") String price,
                                       @RequestParam("imagesProduct") MultipartFile imagesProduct, @RequestParam("images1") MultipartFile images1,
                                       @RequestParam("images2") MultipartFile images2, @RequestParam("images3") MultipartFile images3) throws IOException {

//        System.out.println("brand Product: " + brand);
//        System.out.println("category Product: " + category);
//        System.out.println("type Product: " + type);
//        System.out.println("name Product: " + name);
//        System.out.println("description Product: " + description);
//        System.out.println("describe_specific Product: " + describe_specific);
//        System.out.println("color Product: " + color);
//        System.out.println("price Product: " + price);
//        System.out.println("imagesProduct Product: " + imagesProduct);
//        System.out.println("images1 Product: " + images1);
//        System.out.println("Images2 Product: " + images2);
//        System.out.println("Images3 Product: " + images3);

        // get the origin name of multipartfile images
        String imagesCoverPath = StringUtils.cleanPath(imagesProduct.getOriginalFilename());
        String images1Path = StringUtils.cleanPath(images1.getOriginalFilename());
        String images2Path = StringUtils.cleanPath(images2.getOriginalFilename());
        String images3Path = StringUtils.cleanPath(images3.getOriginalFilename());

        //save product and productdetails
        Product product = productRepository.save(new Product(Long.parseLong(price), description, imagesCoverPath, name ));
        Productdetails productdetails = productDetailsRepository.save(new Productdetails(product.getId(), Long.parseLong(price), brand, describe_specific, images1Path, images2Path, images3Path, name, category, type, color));

        //Set new path images of product by id product
        String newCoverPath = "/images/" + product.getId() + "_" + imagesCoverPath;
        String newImage1Path = "/images/" + brand + "/" + product.getId() + "_" +  productdetails.getId() + "_" + "1"  + images1Path;
        String newImage2Path = "/images/" + brand + "/" + product.getId() + "_" +  productdetails.getId() + "_" + "2"  + images1Path;
        String newImage3Path = "/images/" + brand + "/" + product.getId() + "_" +  productdetails.getId() + "_" + "3"  + images1Path;

        product.setImages(newCoverPath);
        productdetails.setImages_1(newImage1Path);
        productdetails.setImages_2(newImage2Path);
        productdetails.setImages_3(newImage3Path);

        //update images path of product by id product
        productService.updateImagesPathOfProduct(newCoverPath, product.getId());
        adminService.updatePathOf3ImagesInProductDetails(newImage1Path, newImage2Path, newImage3Path, productdetails.getId());

        //Save images
        FileUploadUtils.saveFile("src/main/resources/static/images",product.getId()+"_"+ imagesCoverPath, imagesProduct);
        FileUploadUtils.saveFile("src/main/resources/static/images/" + brand, product.getId() + "_" +  productdetails.getId() + "_" + "1"  + images1Path, images1);
        FileUploadUtils.saveFile("src/main/resources/static/images/" + brand, product.getId() + "_" +  productdetails.getId() + "_" + "2"  + images2Path, images2);
        FileUploadUtils.saveFile("src/main/resources/static/images/" + brand, product.getId() + "_" +  productdetails.getId() + "_" + "3"  + images3Path, images3);

        return new RedirectView("/adminpage/{idadmin}");
    }


}
