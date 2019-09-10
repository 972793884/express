package com.star.controller;

import com.star.Utils.Ret;
import com.star.Utils.SendEmail;
import com.star.service.ExpressService;
import com.star.vo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RequestMapping("notify")
@RestController
public class NotifyController {
    @Autowired
    ExpressService expressService;
    @PostMapping("notifyUser")
    Ret notifyUser(Integer id) {
        Express express=expressService.getExpressById(id);
        String phone = express.getPhoneRecive();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("mmss");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,2);
        Date latestTime=calendar.getTime();
        express.setLatestPickupTime(latestTime);
        String pickupCode=simpleDateFormat2.format(latestTime);
        express.setPickupCode(pickupCode);
        express.setStatus(2);
        express.save();
        new Thread(){
            @Override
            public void run() {
                SendEmail.send(phone,express.getUserNameRecive(),pickupCode,simpleDateFormat.format(latestTime));
            }
        }.start();
        return Ret.ok();
    }
}
