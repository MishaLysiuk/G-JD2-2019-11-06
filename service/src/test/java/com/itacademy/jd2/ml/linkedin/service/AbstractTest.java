package com.itacademy.jd2.ml.linkedin.service;

import java.util.Random;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.impl.CompanyServiceImpl;
import com.itacademy.jd2.ml.linkedin.impl.UserPortfolioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:service-context.xml")
public abstract class AbstractTest {
    @Autowired
    protected IUserPortfolioService userPortfolioService;
    @Autowired
    protected ICompanyService companyService;

    private static final Random RANDOM = new Random();

    @BeforeEach
    public void setUpMethod() {
        // clean DB recursive
        //modelService.deleteAll();
        userPortfolioService.deleteAll();
    }

    protected String getRandomPrefix() {
        return RANDOM.nextInt(99999) + "";
    }

    protected int getRandomObjectsCount() {
        return RANDOM.nextInt(9) + 1;
    }

    public Random getRANDOM() {
        return RANDOM;
    }

    protected IUserPortfolio saveNewUser() {
        final IUserPortfolio entity = userPortfolioService.createEntity();
        entity.setFirstName("user-" + getRandomPrefix());
        userPortfolioService.save(entity);
        return entity;
    }

    protected ICompany saveNewCompany() {
        final ICompany entity = companyService.createEntity();
        entity.setName("company-" + getRandomPrefix());
        companyService.save(entity);
        return entity;
    }

}