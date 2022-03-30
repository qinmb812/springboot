package com.at.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot12TaskApplicationTests {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("2449338367@qq.com");
        message.setFrom("2449338367@qq.com");
        javaMailSender.send(message);
    }

    @Test
    void test02() throws Exception {
        // 1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7:30开会</b>",true);
        helper.setTo("2449338367@qq.com");
        helper.setFrom("2449338367@qq.com");

        // 上传文件
        helper.addAttachment("1.jpg", new File("C:\\Users\\asus\\Desktop\\MVC原理图.png"));

        javaMailSender.send(mimeMessage);
    }
}
