package com.star.service;

import com.star.vo.ExpressOrder;

import java.util.List;

public interface ExpressOrderService {
    List<ExpressOrder> findAll();

    ExpressOrder getExpressOrderById(Integer id);

    Integer saveExpressOrder(ExpressOrder expressOrder);

    Integer updateExpressOrder(ExpressOrder expressOrder);

    Integer delExpressOrder(Integer id);

    Integer sendExpressOrder(ExpressOrder expressOrder);
}
