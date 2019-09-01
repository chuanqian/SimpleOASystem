package com.zaqacu.service.impl;

import com.zaqacu.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    //注入邮件发送对象
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendEmailCheck(String from, String to, String subject, String content) {

        //创建普通邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //定义发送者邮件地址
        message.setFrom(from);
        //定义接受者邮件地址
        message.setTo(to);
        //定义邮件主题，就是邮件标题
        message.setSubject(subject);
        //定义邮件内容
        message.setText(content);

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
