package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.Utils.SendEmail;
import com.star.service.ExpressService;
import com.star.vo.Express;
import com.star.vo.ExpressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("express")
@RestController
public class ExpressController {
    @Autowired
    private ExpressService expressService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getExpressList")
    Ret getExpressList() {
        List<Express> list = expressService.findAll();
        return Ret.ok().set("expressList", list);
    }
    @GetMapping("getMyExpressList")
    List<Express> getMyExpressList(String code,String phoneRecive) {
        List<Express> list = expressService.getMyExpressList(code,phoneRecive);
        return list;
    }

    @GetMapping("getExpressById")
    Ret getExpressById(Integer id) {
        Express express = expressService.getExpressById(id);
        return Ret.ok().set("express", express);
    }

    @PostMapping("saveExpress")
    Ret saveExpress(Express express) {
        Integer result = expressService.saveExpress(express);
        if (express.getExpressOrderId() != null) {
            ExpressOrder expressOrder = new ExpressOrder();
            expressOrder.setId(express.getExpressOrderId());
            expressOrder.setStatus(2);
            expressOrder.save();
        }

        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("updateExpress")
    Ret updateExpress(Express express) {
        Integer result = express.save();
        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("delExpress")
    Ret delExpress(Integer id) {
        Integer result = expressService.delExpress(id);
        return result > 0 ? Ret.ok() : Ret.fail();
    }

    @GetMapping("test")
    Ret test() {
        expressService.updateOverTime();
        return Ret.ok();
    }
}
