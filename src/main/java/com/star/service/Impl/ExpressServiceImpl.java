package com.star.service.Impl;

import com.star.Utils.SendEmail;
import com.star.mapper.ExpressMapper;
import com.star.service.ExpressService;
import com.star.vo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class ExpressServiceImpl implements ExpressService {
    @Autowired
    ExpressMapper expressMapper;
    @Override
    public List<Express> findAll() {
        return expressMapper.findAll();
    }

    @Override
    public Express getExpressById(Integer id) {
        return expressMapper.getExpressById(id);
    }

    @Override
    public Integer saveExpress(Express express) {
        express.setIsDelete(0);
        express.setCreateTime(new Date());
        express.setOvertime(0);
        //生成订单号 日期+快递公司+编号
        StringBuffer code=new StringBuffer();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        String date=simpleDateFormat.format(new Date());
        code.append(date);
        code.append("WAKD");
        Integer num =expressMapper.getNum()+1;
        code.append(String.format("%04d",num));
        express.setCode(code.toString());
        if (express.getExpressOrderId()==null){
            express.setStatus(1);//非订单过来的快件直接发件
        }else {
            express.setStatus(0);//订单过来的快件待发件
        }
        return expressMapper.saveExpress(express);
    }

    @Override
    public Integer updateExpress(Express express) {
        return expressMapper.updateExpress(express);
    }

    @Override
    public Integer delExpress(Integer id) {
        Express express =getExpressById(id);
        express.setIsDelete(1);
        return expressMapper.updateExpress(express);
    }

    @Override
    public Integer findExpressIdByExpressOrderId(Integer expressOrderId) {
        return expressMapper.findExpressIdByExpressOrderId(expressOrderId);
    }

    @Override
    public List<Express> getAllNotPickupExpress() {
        return expressMapper.getAllNotPickupExpress();
    }

    @Override
    public void updateOverTime() {
        List<Express> list =getAllNotPickupExpress();
        for (Express express:list){
            Date now =new Date();
            if (express.getLatestPickupTime().getTime()<now.getTime()){
                express.setOvertime(1);
                express.setOvertimeTime(now);
                express.setStatus(3);
                express.save();
                new Thread(){
                    @Override
                    public void run() {
                        SendEmail.send(express.getPhoneRecive(),express.getUserNameRecive(),express.getCode());
                    }
                }.start();
            }
        }
    }

    @Override
    public List<Express> getMyExpressList(String code, String phoneRecive) {
        return expressMapper.getMyExpressList(code,phoneRecive);
    }
}
