package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageLevelServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final ILanguageLevel entity = levelService.createEntity();
        entity.setName("level" + getRandomPrefix());
        entity.setPriority(getRandomObjectsCount());
        levelService.save(entity);

        final ILanguageLevel entityFromDb = levelService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getName(), entityFromDb.getName());
        assertEquals(entity.getPriority(), entityFromDb.getPriority());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
