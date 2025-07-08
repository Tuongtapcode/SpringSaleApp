/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.services.impl;

import com.nnt.pojo.Category;
import com.nnt.reponsitories.CategoryReponsitory;
import com.nnt.servives.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngoct
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryReponsitory categoryRepo;

    @Override
    public List<Category> getCates() {
        return this.categoryRepo.getCates();
    }

}
