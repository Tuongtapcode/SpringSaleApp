/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.servives;

import com.nnt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ngoct
 */
public interface ProductService {

    List<Product> getProducts(Map<String, String> params);

    void addOrUppdateProduct(Product p);

    Product getProductById(int id);

    void deleteProduct(int id);

}
