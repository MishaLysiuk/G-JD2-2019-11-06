package com.itacademy.jd2.ml.linkedin.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.itacademy.jd2.ml.linkedin.*;
import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.*;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
public abstract class AbstractTest {
    @Autowired
    protected ISkillService skillService;
    @Autowired
    protected IGroupSkillService groupService;
    @Autowired
    protected IUserAccountService userAccountService;
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

    protected IUserAccount saveNewUser() {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setEmail("email-" + getRandomPrefix());
        entity.setPassword("password-" + getRandomPrefix());
        entity.setRoleId(Role.ADMIN);
        entity.setFirstName("qwerty-" + getRandomPrefix());
        entity.setLastName("lastName-" + getRandomPrefix());
        entity.setBirthday(new Date());
        userAccountService.save(entity);
        return entity;
    }

    protected ICompany saveNewCompany() {
        final ICompany entity = companyService.createEntity();
        entity.setName("company-" + getRandomPrefix());
        companyService.save(entity);
        return entity;
    }

    protected IGroupSkill saveNewGroup() {
        final IGroupSkill entity = groupService.createEntity();
        entity.setName("name-" + getRandomPrefix());
        groupService.save(entity);
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