/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nnt.hibernatedemo;

import com.nnt.reponsitories.impl.CategoryReponsitoryImpl;
import com.nnt.reponsitories.impl.ProductReponsitoryImpl;
import com.nnt.reponsitories.impl.StatsReponsitoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ngoct
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryReponsitoryImpl s = new CategoryReponsitoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));
//        ProductReponsitoryImpl s = new ProductReponsitoryImpl();
//
//        Map<String, String> params = new HashMap<>();
////        params.put("kw", "iPhone");
////        params.put("fromPrice", "28000000");
//        params.put("page", "2");
//
//        s.getProducts(params).forEach(p -> System.out.printf("%d - %s -%.1f\n", p.getId(), p.getName(), p.getPrice()));
        StatsReponsitoryImpl stats = new StatsReponsitoryImpl();
//        stats.statsRevenueByProduct().forEach(o
//                -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2])
//        );
        stats.statsRevenueByTime("QUARTER", 2020).forEach(o
                -> System.out.printf("%d: %d\n", o[0], o[1])
        );

    }
}
