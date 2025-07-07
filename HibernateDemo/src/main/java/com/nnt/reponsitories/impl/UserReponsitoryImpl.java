/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.reponsitories.impl;

import com.nnt.hibernatedemo.HibernateConfigs;
import com.nnt.pojo.User;
import jakarta.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author ngoct
 */
public class UserReponsitoryImpl {

    public User getUserByUsername(String username) {
        try (Session s = HibernateConfigs.getFACTORY().openSession()) {
            Query q = s.createNamedQuery("User.findByUsername", User.class);
            q.setParameter("username", username);
            return (User) q.getSingleResult();
        }
    }

}
