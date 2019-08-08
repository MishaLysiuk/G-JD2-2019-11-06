package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkillServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final ISkill entity = skillService.createEntity();
        entity.setName("skill-" + getRandomPrefix());
        entity.setGroup(saveNewGroup());
        skillService.save(entity);

        final ISkill entityFromDb = skillService.getFullInfo(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getName(), entityFromDb.getName());
        assertEquals(entity.getGroup().getId(), entityFromDb.getGroup().getId());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }
    
}
