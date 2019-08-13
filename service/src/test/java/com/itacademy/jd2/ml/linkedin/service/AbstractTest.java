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
    @Autowired
    protected IVacancyService vacancyService;
    @Autowired
    protected IAddressService addressService;
    @Autowired
    protected ICityService cityService;
    @Autowired
    protected ICountryService countryService;
    @Autowired
    protected IRegionService regionService;

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
        entity.setRoleId(Role.USER);
        entity.setFirstName("firstName-" + getRandomPrefix());
        entity.setLastName("lastName-" + getRandomPrefix());
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

    protected IAddress saveNewAddress() {
        final IAddress entity = addressService.createEntity();
        entity.setAddress("name-" + getRandomPrefix());
        entity.setCity(saveNewCity());
        addressService.save(entity);
        return entity;
    }

    protected ICity saveNewCity() {
        final ICity entity = cityService.createEntity();
        entity.setNameId(getRandomObjectsCount());
        entity.setCountry(saveNewCountry());
        cityService.save(entity);
        return entity;
    }

    protected ICountry saveNewCountry() {
        final ICountry entity = countryService.createEntity();
        entity.setNameId(getRandomObjectsCount());
        entity.setRegion(saveNewRegion());
        countryService.save(entity);
        return entity;
    }

    protected IRegion saveNewRegion() {
        final IRegion entity = regionService.createEntity();
        entity.setNameId(getRandomObjectsCount());
        regionService.save(entity);
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