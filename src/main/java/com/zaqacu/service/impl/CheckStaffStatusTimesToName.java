package com.zaqacu.service.impl;

import com.zaqacu.constant.CheckTypeConstant;
import com.zaqacu.service.CheckStaffStatusService;
import com.zaqacu.service.EmailService;
import com.zaqacu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class CheckStaffStatusTimesToName {
    @Autowired
    private CheckStaffStatusService checkStaffStatusService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private StaffService staffService;
    //3.添加定时任务
    @Scheduled(cron = "0 0 6 * * MON,TUE,WED,THU,FRI")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        checkStaffStatusService.editStatusNameByTimes(CheckTypeConstant.NOTCHECK);
    }

    @Scheduled(cron = "0 30 8 * * MON,TUE,WED,THU,FRI")
    private void configureTimes(){
        System.out.println("执行动态的代码："+123456789);
        List<String> emailName = staffService.getAllPositionByPositionName("人事");
        for (String s : emailName) {
            emailService.sendEmailCheck("1178995389@qq.com",s,"考勤","九点请准时对员工进行检查");
        }
        //emailService.sendEmailCheck("1178995389@qq.com","1784602582@qq.com","今天你好","世界你好");
    }

}
