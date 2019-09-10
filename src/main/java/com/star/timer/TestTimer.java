package com.star.timer;

import com.star.service.ExpressService;
import com.star.vo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Configuration
@EnableScheduling
public class TestTimer {
    @Autowired
    ExpressService expressService;

    //秒(, - * /) 分(, - * /) 时(, - * /) 日(, - * ? / L W ) 周(, - * ? / L #) 月(, - * /) 年(, - * /)  年非必写
    @Scheduled(cron = "0/10 * * * * ?")
    public void aa() {
        System.out.println("start");
    }
    //每日凌晨0点执行任务
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateOverTime() {
        expressService.updateOverTime();
    }
}
