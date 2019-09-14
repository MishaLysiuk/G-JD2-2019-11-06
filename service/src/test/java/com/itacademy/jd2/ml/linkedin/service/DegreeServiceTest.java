package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DegreeServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        IDegree entity = degreeService.createEntity();
        entity.setName("Doctor");
        degreeService.save(entity);

        IDegree entityFromDb = degreeService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getName(), entityFromDb.getName());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
