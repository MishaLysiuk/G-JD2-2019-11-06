package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageServiceTest extends AbstractTest {

    @Test
    public void testCreate() {

        final ILanguage entity = languageService.createEntity();
        entity.setName("English");
        languageService.save(entity);

        final ILanguage entity1 = languageService.createEntity();
        entity1.setName("German");
        languageService.save(entity1);

        final ILanguage entity2 = languageService.createEntity();
        entity2.setName("Spanish");
        languageService.save(entity2);

        final ILanguage entity3 = languageService.createEntity();
        entity3.setName("Chinese");
        languageService.save(entity3);

        final ILanguage entity4 = languageService.createEntity();
        entity4.setName("Russian");
        languageService.save(entity4);

        final ILanguage entityFromDb = languageService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getName(), entityFromDb.getName());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
