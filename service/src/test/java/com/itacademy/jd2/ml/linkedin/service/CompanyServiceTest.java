package com.itacademy.jd2.ml.linkedin.service;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final ICompany entity = saveNewCompany();

        final ICompany entityFromDb = companyService.get(entity.getId());

        assertNotNull(entityFromDb);
        assertEquals(entity.getName(), entityFromDb.getName());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testFind() {

        int initialSize = companyService.getAll().size();

        for (int i = 0; i < 6; i++) {
            saveNewCompany();
        }

        CompanyFilter filter = new CompanyFilter();

        assertEquals(initialSize + 6, companyService.getCount(filter));

        filter.setLimit(5);
        assertEquals(5, companyService.find(filter).size());

      /*  filter.setOffset(5);
        assertEquals(1, companyService.find(filter).size());*/

      filter = new CompanyFilter();
        filter.setSortColumn("id");
        filter.setSortOrder(true);
        List<ICompany> ascBrands = companyService.find(filter);
        verifyOrderById(ascBrands, true);

        filter.setSortOrder(false);
        List<ICompany> descBrands = companyService.find(filter);
        verifyOrderById(descBrands, false);
    }

}
