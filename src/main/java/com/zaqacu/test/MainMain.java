package com.zaqacu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MainMain {

//    注入邮件发送对象
    @Autowired
    private JavaMailSender mailSender;

    public void seandMail() {
//        JavaMailSender mailSender=new JavaMailSenderImpl();
        System.out.println("enter");
        //创建普通邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //定义发送者邮件地址
        message.setFrom("1178995389@qq.com");
        //定义接受者邮件地址
        message.setTo("1620646016@qq.com");
        //定义邮件主题，就是邮件标题
        message.setSubject("你好佘老狗");
        //定义邮件内容
        message.setText("今天过的怎么样，嘻嘻");

        try {
            //发送邮件
            mailSender.send(message);
            System.out.println("发送成功");
        } catch (Exception e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
}
