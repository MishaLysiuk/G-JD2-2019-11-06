package com.itacademy.jd2.ml.linkedin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import org.junit.jupiter.api.Test;


public class UserPortfolioServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IUserPortfolio entity = saveNewUser();

        final IUserPortfolio entityFromDb = userPortfolioService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getFirstName(), entityFromDb.getFirstName());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }
}