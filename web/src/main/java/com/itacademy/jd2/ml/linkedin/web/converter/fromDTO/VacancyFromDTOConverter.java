package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VacancyFromDTOConverter implements Function<VacancyDTO, IVacancy> {
    
    private IVacancyService vacancyService;

    @Autowired
    public VacancyFromDTOConverter(IVacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public IVacancy apply(final VacancyDTO dto) {
        final IVacancy entity = vacancyService.createEntity();
        entity.setId(dto.getId());
        entity.setCreator(dto.getCreator());
        entity.setJobTitle(dto.getJobTitle());
        entity.setCompany(dto.getCompany());
        entity.setAddress(dto.getAddress());
        entity.setContactInfo(dto.getContactInfo());
        entity.setDescription(dto.getDescription());
        entity.setCreated(dto.getCreated());
        return entity;
    }
    
}
