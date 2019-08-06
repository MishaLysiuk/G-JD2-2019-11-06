package com.itacademy.jd2.ml.linkedin.service;

import java.util.List;
import java.util.Random;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.entity.table.IBaseEntity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.impl.CompanyServiceImpl;
import com.itacademy.jd2.ml.linkedin.impl.UserPortfolioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
public abstract class AbstractTest {
    @Autowired
    protected IUserPortfolioService userPortfolioService;
    @Autowired
    protected ICompanyService companyService;
    @Autowired
    protected ICourseService courseService;

    private static final Random RANDOM = new Random();

    @BeforeEach
    public void setUpMethod() {
        // clean DB recursive
        //modelService.deleteAll();
       // userPortfolioService.deleteAll();
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

    protected IBaseEntity verifyOrderById(List<? extends IBaseEntity> ascBrands, boolean ascending) {
        IBaseEntity previousEntity = null;
        for (IBaseEntity entity : ascBrands) {
            if (previousEntity == null) {
                previousEntity = entity;
                continue;
            }
            if (ascending) {
                assertTrue(previousEntity.getId().intValue() < entity.getId().intValue());
            } else {
                assertTrue(previousEntity.getId().intValue() > entity.getId().intValue());
            }
            previousEntity = entity;
        }
        return previousEntity;
    }

}