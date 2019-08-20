package com.itacademy.jd2.ml.linkedin.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Properties;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("registration");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView sendGmail(Locale locale){

        ModelAndView modelAndView = new ModelAndView();
        final String username = "username@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

}
