/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.reponsitories;

import com.nnt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ngoct
 */
public interface ProductReponsitory {

    public List<Product> getProducts(Map<String, String> params);

}
