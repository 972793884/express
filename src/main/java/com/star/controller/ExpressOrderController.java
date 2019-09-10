package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.ExpressOrderService;
import com.star.service.ExpressService;
import com.star.vo.Express;
import com.star.vo.ExpressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("expressOrder")
@RestController
public class ExpressOrderController {
    @Autowired
    private ExpressOrderService expressOrderService;
    @Autowired
    PageUtils pageUtils;
    @Autowired
    ExpressService expressService;


    @GetMapping("getExpressOrderList")
    Ret getExpressOrderList() {
        List<ExpressOrder> list = expressOrderService.findAll();
        return Ret.ok().set("expressOrderList", list);
    }
    @GetMapping("getExpressOrderById")
    Ret getExpressOrderById(Integer id) {
        ExpressOrder expressOrder= expressOrderService.getExpressOrderById(id);
        return Ret.ok().set("expressOrder", expressOrder);
    }
    @PostMapping("saveExpressOrder")
    Ret saveExpressOrder(ExpressOrder expressOrder) {
        Integer result= expressOrderService.saveExpressOrder(expressOrder);
        return result>0? Ret.ok():Ret.fail();
    }
    @PostMapping("sendExpressOrder")
    Ret sendExpressOrder(ExpressOrder expressOrder) {
        Integer result= expressOrderService.sendExpressOrder(expressOrder);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("updateExpressOrder")
    Ret updateExpressOrder(ExpressOrder expressOrder ) {
        Integer result= expressOrder.save();
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("delExpressOrder")
    Ret delExpressOrder(Integer id) {
        Integer result= expressOrderService.delExpressOrder(id);
        return result>0? Ret.ok():Ret.fail();
    }
}
