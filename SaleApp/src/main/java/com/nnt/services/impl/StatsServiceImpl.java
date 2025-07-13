/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.services.impl;

import com.nnt.reponsitories.impl.StatsReponsitoryImpl;
import com.nnt.servives.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngoct
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsReponsitoryImpl statsRepo;

    @Override
    public List<Object[]> statsRevenueByProduct() {
        return this.statsRepo.statsRevenueByProduct();
    }

    @Override
    public List<Object[]> statsRevenueByTime(String time, int year) {
        return this.statsRepo.statsRevenueByTime(time, year);
    }

}
