/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.servives;

import java.util.List;

/**
 *
 * @author ngoct
 */
public interface StatsService {

    List<Object[]> statsRevenueByProduct();

    List<Object[]> statsRevenueByTime(String time, int year);
}
