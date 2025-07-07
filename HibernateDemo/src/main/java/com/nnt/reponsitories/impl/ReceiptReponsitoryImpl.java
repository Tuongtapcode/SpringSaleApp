/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.reponsitories.impl;

import com.nnt.hibernatedemo.HibernateConfigs;
import com.nnt.pojo.Cart;
import com.nnt.pojo.OrderDetail;
import com.nnt.pojo.SaleOrder;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ngoct
 */
public class ReceiptReponsitoryImpl {

    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            try (Session s = HibernateConfigs.getFACTORY().openSession()) {
                SaleOrder order = new SaleOrder();
                order.setUserId(new UserReponsitoryImpl().getUserByUsername("dhthanh"));
                order.setCreatedDate(new Date());
                s.persist(order);

                for (var x : carts) {
                       OrderDetail d = new OrderDetail();
                       d.setQuantity(x.getQuantity());
                       d.setUnitPrice(x.getPrice());
                       d.setProductId(new ProductReponsitoryImpl().getProductById(x.getId()));
                       d.setOrderId(order);
                       s.persist(d);
                }
            }
        }
    }
}
