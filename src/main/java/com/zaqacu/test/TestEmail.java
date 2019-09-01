package com.zaqacu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml","classpath:applicationContext-web.xml"})
public class TestEmail {
    @Autowired
    MainMain mainMain;
    @Test
    public void tests() {
        mainMain.seandMail();

    }

}
