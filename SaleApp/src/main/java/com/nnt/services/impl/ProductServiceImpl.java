/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nnt.pojo.Product;
import com.nnt.reponsitories.ProductReponsitory;
import com.nnt.servives.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngoct
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReponsitory ProductRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.ProductRepo.getProducts(params);
    }

    @Override
    public void addOrUppdateProduct(Product p) {
        //upload
        if (!p.getFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.ProductRepo.addOrUppdateProduct(p);
    }

    @Override
    public Product getProductById(int id) {
        return this.ProductRepo.getProductById(id);
    }

    @Override
    public void deleteProduct(int id) {
        this.ProductRepo.deleteProduct(id);
    }

}
