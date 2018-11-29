package com.etc.task;

import com.etc.threadTask.ThreadApple;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeTask {
//    @Scheduled(cron = "0/10 * * * * ?  ")
    public void timeTask(){
        Date date = new Date();
        int minutes = date.getMinutes();
        if (minutes == 42){
            ThreadApple threadApple = new ThreadApple();
            threadApple.start();
        }
        System.out.println("开始："+new Date());
    }
}
