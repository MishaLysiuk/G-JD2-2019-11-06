package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

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
        //assertEquals(entity.getBirthday(), entityFromDb.getBirthday());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testSearch() {
        List<IUserAccount> result = userAccountService.search("qwerty");
        assertTrue(result.isEmpty());

        IUserAccount savedUserAccount = saveNewUser();
        List<IUserAccount> foundModels = userAccountService.search("qwerty");
        assertTrue(foundModels.size() == 1);
        assertTrue(foundModels.get(0).getId().equals(savedUserAccount.getId()));

        /*IUserAccount validUserAccount = saveNewUser();
        result = userAccountService.search("Mike");
        assertEquals(result.size(), 1);
        assertEquals(validUserAccount.getId(), result.get(0).getId());*/
    }

}
