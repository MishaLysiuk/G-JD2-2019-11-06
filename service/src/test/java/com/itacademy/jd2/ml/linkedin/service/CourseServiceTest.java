package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final ICourse entity = courseService.createEntity();
        entity.setName("course-" + getRandomPrefix());
        entity.setCompany(saveNewCompany());
        entity.setStart(new Date());
        entity.setEndDate(new Date());
        courseService.save(entity);

        final ICourse entityFromDb = courseService.getFullInfo(entity.getId());

        assertEquals(entity.getName(), entityFromDb.getName());
        assertEquals(entity.getCompany().getId(), entityFromDb.getCompany().getId());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
        assertTrue(entityFromDb.getStart().equals(entityFromDb.getStart()));
        assertTrue(entityFromDb.getEndDate().equals(entityFromDb.getEndDate()));
    }
    
}
