package com.zaqacu.service;

public interface EmailService {
    /**
     * 发送邮箱
     * @param from 发送号
     * @param to 接收号
     * @param subject 标题
     * @param content 类型
     */
    void sendEmailCheck(String from,String to, String subject, String content);
}
