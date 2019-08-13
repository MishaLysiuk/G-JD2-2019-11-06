package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VacancyToDTOConverter implements Function<IVacancy, VacancyDTO> {


    @Override
    public VacancyDTO apply(IVacancy entity) {
        final VacancyDTO dto = new VacancyDTO();
        dto.setId(entity.getId());
        dto.setCreator(entity.getCreator());
        dto.setActive(entity.getActive());
        dto.setIndustryId(entity.getIndustryId());
        dto.setPositionId(entity.getPositionId());
        dto.setCompany(entity.getCompany());
        dto.setAddress(entity.getAddress());
        dto.setContactInfo(entity.getContactInfo());
        return dto;
    }
}
