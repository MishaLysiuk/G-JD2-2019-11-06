package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegionServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IRegion entity = saveNewRegion();

        final IRegion entityFromDb = regionService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getName(), entityFromDb.getName());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
