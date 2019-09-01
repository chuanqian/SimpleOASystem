package com.zaqacu.service;

public interface EmailService {
    void sendEmailCheck(String from,String to, String subject, String content);
}
