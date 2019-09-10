package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.LogisticsService;
import com.star.vo.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("logistics")
@RestController
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getLogisticsList")
    Ret getLogisticsList() {
        List<Logistics> list = logisticsService.findAll();
        return Ret.ok().set("logisticsList", list);
    }
    @GetMapping("getLogisticsById")
    Ret getLogisticsById(Integer id) {
        Logistics logistics= logisticsService.getLogisticsById(id);
        return Ret.ok().set("logistics", logistics);
    }
    @PostMapping("saveLogistics")
    Ret saveLogistics(Logistics logistics) {
        Integer result= logisticsService.saveLogistics(logistics);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("updateLogistics")
    Ret updateLogistics(Logistics logistics ) {
        Integer result= logisticsService.updateLogistics(logistics);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("delLogistics")
    Ret delLogistics(Integer id) {
        Integer result= logisticsService.delLogistics(id);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("getMyLogisticsList")
    List<Logistics> getMyLogisticsList(Integer id) {
        List<Logistics> result= logisticsService.getMyLogisticsList(id);
        return result;
    }
}
