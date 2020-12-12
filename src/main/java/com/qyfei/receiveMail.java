package com.qyfei;

import com.sun.mail.pop3.POP3SSLStore;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class receiveMail {
    public static void  main(String[] args) throws MessagingException, IOException {
        String host = "pop.163.com";
        int port = 995;
        String username = "qiyanfei1986@163.com";
        String password = "VOQGWBZYNBOAVZGE";
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "pop3");
        properties.setProperty("mail.pop3.host", host);
        properties.setProperty("mail.pop3.port", String.valueOf(port));

        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", String.valueOf(port));

        URLName urlName = new URLName("pop3",host,port,"",username,password);
        Session session = Session.getInstance(properties,null);
        session.setDebug(true);
        Store store=new POP3SSLStore(session,urlName);
        store.connect();
        Folder folder=store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);
        System.out.println("Total masssage :"+folder.getMessageCount());
        System.out.println("New message :"+folder.getNewMessageCount());
        System.out.println("Unread message :"+folder.getUnreadMessageCount());
        System.out.println("Deleted message :"+folder.getDeletedMessageCount());

        Message[] messages= folder.getMessages();
        for (Message message:messages
             ) {
        printMessage((MimeMessage)message);
        }

        folder.close(true); // 传入true表示删除操作会同步到服务器上（即删除服务器收件箱的邮件）
        store.close();
    }
   static void printMessage(MimeMessage msg) throws IOException, MessagingException {
        // 邮件主题:
        System.out.println("Subject: " + MimeUtility.decodeText(msg.getSubject()));
        // 发件人:
        Address[] froms = msg.getFrom();
        InternetAddress address = (InternetAddress) froms[0];
        String personal = address.getPersonal();
        String from = personal == null ? address.getAddress() : (MimeUtility.decodeText(personal) + " <" + address.getAddress() + ">");
        System.out.println("From: " + from);
       System.out.println("Received at "+msg.getSender());
    }
    String getBody(Part part) throws MessagingException, IOException {
        if (part.isMimeType("text/*")) {
            // Part是文本:
            return part.getContent().toString();
        }
        if (part.isMimeType("multipart/*")) {
            // Part是一个Multipart对象:
            Multipart multipart = (Multipart) part.getContent();
            // 循环解析每个子Part:
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String body = getBody(bodyPart);
                if (!body.isEmpty()) {
                    return body;
                }
            }
        }
        return "";
    }
}
