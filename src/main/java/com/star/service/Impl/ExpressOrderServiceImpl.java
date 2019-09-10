package com.star.service.Impl;

import com.star.mapper.ExpressOrderMapper;
import com.star.service.ExpressOrderService;
import com.star.service.ExpressService;
import com.star.vo.Express;
import com.star.vo.ExpressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpressOrderServiceImpl implements ExpressOrderService {
    @Autowired
    ExpressOrderMapper expressOrderMapper;
    @Autowired
    ExpressService expressService;

    @Override
    public List<ExpressOrder> findAll() {
        return expressOrderMapper.findAll();
    }

    @Override
    public ExpressOrder getExpressOrderById(Integer id) {
        return expressOrderMapper.getExpressOrderById(id);
    }

    @Override
    public Integer saveExpressOrder(ExpressOrder expressOrder) {
        expressOrder.setIsDelete(0);
        expressOrder.setStatus(0);
        expressOrder.setCreateTime(new Date());
        return expressOrderMapper.saveExpressOrder(expressOrder);
    }

    @Override
    public Integer updateExpressOrder(ExpressOrder expressOrder) {
        return expressOrderMapper.updateExpressOrder(expressOrder);
    }

    @Override
    public Integer delExpressOrder(Integer id) {
        ExpressOrder expressOrder = getExpressOrderById(id);
        expressOrder.setIsDelete(1);
        return expressOrderMapper.updateExpressOrder(expressOrder);
    }

    @Override
    public Integer sendExpressOrder(ExpressOrder expressOrder) {
        Integer result= expressOrder.save();
        Integer expressId= expressService.findExpressIdByExpressOrderId(expressOrder.getId());
        Express express =new Express();
        express.setId(expressId);
        express.setStatus(1);
        Integer result2 = express.save();
        return result>0&&result2>0?1:-1;
    }
}
