package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupSkillServiceTest extends AbstractTest {

    @Test
    public void testCreate() {

        final IGroupSkill entity = saveNewGroup();

        final IGroupSkill entityFromDb = groupService.get(entity.getId());

        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertEquals(entity.getName(), entityFromDb.getName());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
        
    }

}
