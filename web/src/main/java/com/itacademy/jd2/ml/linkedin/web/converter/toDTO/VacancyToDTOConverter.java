package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

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
        dto.setJobTitle(entity.getJobTitle());
        dto.setCompany(entity.getCompany());
        dto.setAddress(entity.getAddress());
        dto.setContactInfo(entity.getContactInfo());
        dto.setDescription(entity.getDescription());
        dto.setCreated(entity.getCreated());
        return dto;
    }
}
