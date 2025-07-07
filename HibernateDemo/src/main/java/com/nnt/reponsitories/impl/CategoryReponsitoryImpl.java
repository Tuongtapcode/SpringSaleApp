/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.reponsitories.impl;

import com.nnt.hibernatedemo.HibernateConfigs;
import com.nnt.pojo.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ngoct
 */
public class CategoryReponsitoryImpl {

    public List<Category> getCates() {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            Query q = s.createQuery("FROM Category", Category.class);
            return q.getResultList();
        }
    }
}
