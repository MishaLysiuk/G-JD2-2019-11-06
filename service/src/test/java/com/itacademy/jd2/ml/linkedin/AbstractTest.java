package com.itacademy.jd2.ml.linkedin;

import java.util.Random;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.impl.UserPortfolioServiceImpl;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {
    protected IUserPortfolioService userPortfolioService = new UserPortfolioServiceImpl();

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

}