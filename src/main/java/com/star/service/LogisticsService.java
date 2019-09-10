package com.star.service;

import com.star.vo.Logistics;

import java.util.List;

public interface LogisticsService {
    List<Logistics> findAll();

    Logistics getLogisticsById(Integer id);

    Integer saveLogistics(Logistics logistics);

    Integer updateLogistics(Logistics logistics);

    Integer delLogistics(Integer id);

    List<Logistics> getMyLogisticsList(Integer id);
}
