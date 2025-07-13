/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.pojo.Product;
import com.nnt.servives.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ngoct
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute(value = "product") Product product) {
        this.productService.addOrUppdateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/{productId}")
    public String updateProduct(Model model, @PathVariable(value = "productId") int id){
          model.addAttribute("product", this.productService.getProductById(id));
          return "products";
    }
}
