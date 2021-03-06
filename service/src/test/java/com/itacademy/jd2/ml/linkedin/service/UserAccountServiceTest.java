package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
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
        entity.setEmail("email-" + getRandomPrefix() + "@gmail.com");
        entity.setPassword("password-" + getRandomPrefix());
        entity.setRole(Role.USER);
        entity.setFirstName("firstName-" + getRandomPrefix());
        entity.setLastName("lastName-" + getRandomPrefix());
        userAccountService.save(entity);

        final IUserAccount entityFromDb = userAccountService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getEmail(), entityFromDb.getEmail());
        assertEquals(entity.getPassword(), entityFromDb.getPassword());
        assertEquals(entity.getRole(), entityFromDb.getRole());
        assertEquals(entity.getFirstName(), entityFromDb.getFirstName());
        assertEquals(entity.getLastName(), entityFromDb.getLastName());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testAddAdmin() {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setEmail("admin@gmail.com");
        entity.setPassword("admin");
        entity.setRole(Role.ADMIN);
        entity.setFirstName("admin");
        entity.setLastName("admin");
        entity.setJobTitle("admin job title");
        entity.setContactInfo("admin contact info");
        entity.setMotherTongue(saveNewLanguage());
        userAccountService.save(entity);
    }

    @Test
    public void testAddUser() {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setEmail("worker@gmail.com");
        entity.setPassword("1234");
        entity.setRole(Role.USER);
        entity.setFirstName("Worker");
        entity.setLastName("Worker");
        entity.setJobTitle("Senior Scala Developer");
        entity.setContactInfo("skype: worker322, email: worker@gmail.com");
        ILanguage motherTongue = languageService.createEntity();
        motherTongue.setId(7);
        entity.setMotherTongue(motherTongue);
        userAccountService.save(entity);
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
