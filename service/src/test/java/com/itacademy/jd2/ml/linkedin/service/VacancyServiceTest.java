package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacancyServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IVacancy entity = vacancyService.createEntity();
        entity.setCreator(saveNewUser());
        entity.setActive(true);
        entity.setIndustryId(1);
        entity.setPositionId(3);
        entity.setCompany(saveNewCompany());
        entity.setAddress(saveNewAddress());
        entity.setContactInfo("info-" + getRandomPrefix());
        vacancyService.save(entity);

        final IVacancy entityFromDb = vacancyService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getCreator().getId(), entityFromDb.getCreator().getId());
        assertEquals(entity.getActive(), entityFromDb.getActive());
        assertEquals(entity.getIndustryId(), entityFromDb.getIndustryId());
        assertEquals(entity.getPositionId(), entityFromDb.getPositionId());
        assertEquals(entity.getCompany().getId(), entityFromDb.getCompany().getId());
        assertEquals(entity.getAddress().getId(), entityFromDb.getAddress().getId());
        assertEquals(entity.getContactInfo(), entityFromDb.getContactInfo());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
