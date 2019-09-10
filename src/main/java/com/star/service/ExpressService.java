package com.star.service;

import com.star.vo.Express;

import java.util.List;

public interface ExpressService {
    List<Express> findAll();

    Express getExpressById(Integer id);

    Integer saveExpress(Express express);

    Integer updateExpress(Express express);

    Integer delExpress(Integer id);

    Integer findExpressIdByExpressOrderId(Integer expressOrderId);

    List<Express> getAllNotPickupExpress();

    void updateOverTime();

    List<Express> getMyExpressList(String code, String phoneRecive);
}
