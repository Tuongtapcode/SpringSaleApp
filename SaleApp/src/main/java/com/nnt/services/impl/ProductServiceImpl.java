/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.services.impl;

import com.nnt.pojo.Product;
import com.nnt.reponsitories.ProductReponsitory;
import com.nnt.servives.ProductService;
import java.util.List;
import java.util.Map;
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
    
    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.ProductRepo.getProducts(params);
    }
    
}
