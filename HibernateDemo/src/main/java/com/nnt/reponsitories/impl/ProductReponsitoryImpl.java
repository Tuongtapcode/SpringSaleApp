/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.reponsitories.impl;

import com.nnt.hibernatedemo.HibernateConfigs;
import com.nnt.pojo.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author ngoct
 */
public class ProductReponsitoryImpl {

    private static final int PAGE_SIZE = 6;

    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);

            // Lọc dữ liệu
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
                }
                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
                }

                q.where(predicates.toArray(Predicate[]::new));
                // Xắp xếp dữ liệu
                q.orderBy(b.desc(root.get(params.getOrDefault("sortBy", "id"))));
            }

            // Phân trang dữ liệu
            Query query = s.createQuery(q);
            if (params != null) {
                String page = params.get("page");
                if (page != null) {
                    int p = Integer.parseInt(page);
                    int start = (p - 1) * PAGE_SIZE;
                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
            }

            return query.getResultList();

        }
    }

    public Product getProductById(int id) {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            return s.get(Product.class, id);
        }
    }

    public void addOrUpdateProduct(Product p) {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            if (p.getId() == null) {
                s.persist(p);
            } else {
                s.merge(p);
            }
        }
    }

    // Vấn đáp thầy hay hỏi ********
    public void deleteProduct(int id) {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            Product p = this.getProductById(id);

            s.remove(p);

        }
    }
}
