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
        entity.setJobTitle("jobTitle-" + getRandomPrefix());
        entity.setCompany(saveNewCompany());
        entity.setCity(saveNewCity());
        entity.setAddress("address" + getRandomPrefix());
        entity.setDescription("description" + getRandomPrefix());
        entity.setContactInfo("info-" + getRandomPrefix());
        vacancyService.save(entity);

        final IVacancy entityFromDb = vacancyService.getFullInfo(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getCreator().getId(), entityFromDb.getCreator().getId());
        assertEquals(entity.getJobTitle(), entityFromDb.getJobTitle());
        assertEquals(entity.getCompany().getId(), entityFromDb.getCompany().getId());
        assertEquals(entity.getCity().getId(), entityFromDb.getCity().getId());
        assertEquals(entity.getContactInfo(), entityFromDb.getContactInfo());
        assertEquals(entity.getDescription(), entityFromDb.getDescription());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));

    }

}
