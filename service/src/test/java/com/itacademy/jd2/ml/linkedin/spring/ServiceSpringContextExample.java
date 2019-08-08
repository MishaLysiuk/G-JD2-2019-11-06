package com.itacademy.jd2.ml.linkedin.spring;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceSpringContextExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
        System.out.println(context.getBean(IUserAccountService.class));

//TODO show multiple candidates with Qualifier
    }
}