package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.*;
import com.itacademy.jd2.ml.linkedin.web.dto.WorkExperienceDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class WorkExperienceToDTOConverter implements Function<IWorkExperience, WorkExperienceDTO> {


    @Override
    public WorkExperienceDTO apply(IWorkExperience entity) {
        WorkExperienceDTO dto = new WorkExperienceDTO();
        dto.setId(entity.getId());
        dto.setJobTitle(entity.getJobTitle());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setAddress(entity.getAddress());

        ICompany company = entity.getCompany();
        if (company != null) {
            dto.setCompanyName(company.getName());

            ICity city = entity.getCity();
            dto.setCityId(city.getId());

            ICountry country = city.getCountry();
            dto.setCountryId(country.getId());

            IRegion region = country.getRegion();
            dto.setRegionId(region.getId());
        }

        return dto;
    }
}
