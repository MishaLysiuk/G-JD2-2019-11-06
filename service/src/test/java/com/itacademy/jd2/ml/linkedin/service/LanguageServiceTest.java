package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageServiceTest extends AbstractTest {

    @Test
    public void testCreate() {

        final ILanguage entity = saveNewLanguage();
        languageService.save(entity);

        /*final ILanguage entity1 = languageService.createEntity();
        entity1.setName("Belarussian");
        languageService.save(entity1);

        final ILanguage entity2 = languageService.createEntity();
        entity2.setName("Czech");
        languageService.save(entity2);

        final ILanguage entity3 = languageService.createEntity();
        entity3.setName("English");
        languageService.save(entity3);

        final ILanguage entity4 = languageService.createEntity();
        entity4.setName("German");
        languageService.save(entity4);

        final ILanguage entity5 = languageService.createEntity();
        entity5.setName("Greek");
        languageService.save(entity5);

        final ILanguage entity6 = languageService.createEntity();
        entity6.setName("Hindi");
        languageService.save(entity6);

        final ILanguage entity7 = languageService.createEntity();
        entity7.setName("Italian");
        languageService.save(entity7);

        final ILanguage entity8 = languageService.createEntity();
        entity8.setName("Japanese");
        languageService.save(entity8);

        final ILanguage entity9 = languageService.createEntity();
        entity9.setName("Polish");
        languageService.save(entity9);

        final ILanguage entity10 = languageService.createEntity();
        entity10.setName("Russian");
        languageService.save(entity10);

        final ILanguage entity11 = languageService.createEntity();
        entity11.setName("Spanish");
        languageService.save(entity11);*/

        final ILanguage entityFromDb = languageService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getName(), entityFromDb.getName());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
