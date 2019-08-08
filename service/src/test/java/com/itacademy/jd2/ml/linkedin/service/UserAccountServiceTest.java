package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAccountServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setEmail("email-" + getRandomPrefix());
        entity.setPassword("password-" + getRandomPrefix());
        entity.setRoleId(Role.ADMIN);
        entity.setFirstName("firstName-" + getRandomPrefix());
        entity.setLastName("lastName-" + getRandomPrefix());
        entity.setBirthday(new Date());
        userAccountService.save(entity);

        final IUserAccount entityFromDb = userAccountService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getEmail(), entityFromDb.getEmail());
        assertEquals(entity.getPassword(), entityFromDb.getPassword());
        assertEquals(entity.getRoleId(), entityFromDb.getRoleId());
        assertEquals(entity.getFirstName(), entityFromDb.getFirstName());
        assertEquals(entity.getLastName(), entityFromDb.getLastName());
        assertEquals(entity.getBirthday(), entityFromDb.getBirthday());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

}
