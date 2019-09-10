package com.star.service.Impl;

import com.star.mapper.LogisticsMapper;
import com.star.service.LoginService;
import com.star.service.LogisticsService;
import com.star.vo.Logistics;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    LogisticsMapper logisticsMapper;
    @Autowired
    LoginService loginService;
    @Override
    public List<Logistics> findAll() {
        return logisticsMapper.findAll();
    }

    @Override
    public Logistics getLogisticsById(Integer id) {
        return logisticsMapper.getLogisticsById(id);
    }

    @Override
    public Integer saveLogistics(Logistics logistics) {
        String name = (String)SecurityUtils.getSubject().getPrincipal();
        logistics.setCreateUser(loginService.findByName(name).getId());
        logistics.setCreateTime(new Date());
        logistics.setIsDelete(0);
        return logisticsMapper.saveLogistics(logistics);
    }

    @Override
    public Integer updateLogistics(Logistics logistics) {
        return logisticsMapper.updateLogistics(logistics);
    }

    @Override
    public Integer delLogistics(Integer id) {
        Logistics logistics =getLogisticsById(id);
        logistics.setIsDelete(1);
        return logisticsMapper.updateLogistics(logistics);
    }

    @Override
    public List<Logistics> getMyLogisticsList(Integer id) {
        return logisticsMapper.getMyLogisticsList(id);
    }
}
