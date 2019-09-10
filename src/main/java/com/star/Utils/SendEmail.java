package com.star.Utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class SendEmail {
    public static void send(String reciveEmail,String name,String code,String time) {
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；smtp.exmail.qq.com没测试成功
            email.setHostName("smtp.qq.com");
            email.setSmtpPort(465);
            //开启 SSL 加密
            email.setSSLOnConnect(true);
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo(reciveEmail);
            // 发送人的邮箱
            email.setFrom("2503643444@qq.com", "xxx大学快递代收点");
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和得到的授权码
            email.setAuthentication("2503643444@qq.com", "duqzordnvfjkdjda");
            email.setSubject("您好!"+name+"同学,你的快件已到!");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签

            email.setMsg("您的快递已到 取件码:"+code+"  请及时取件 最晚取件时间"+time);
            // 发送
            email.send();

            System.out.println ( "邮件发送成功!" );
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println ( "邮件发送失败!" );
        }
    }
    public static void send(String reciveEmail,String name,String code) {
        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName("smtp.qq.com");
            email.setSmtpPort(465);
            email.setSSLOnConnect(true);
            email.setCharset("utf-8");
            email.addTo(reciveEmail);
            email.setFrom("2503643444@qq.com", "xxx大学快递代收点");
            email.setAuthentication("2503643444@qq.com", "duqzordnvfjkdjda");
            email.setSubject("您好!"+name+"同学,你的快件已超时!");
            email.setMsg("您的快递已超出最晚提取时间!<br/>订单号:"+code+"<br/>如有疑问可联系:0325-5587xxx。");
            email.send();
            System.out.println ( "邮件发送成功!" );
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println ( "邮件发送失败!" );
        }
    }

}

