package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.*;
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
        dto.setJobTitle(entity.getJobTitle());
        dto.setAddress(entity.getAddress());
        dto.setContactInfo(entity.getContactInfo());
        dto.setDescription(entity.getDescription());
        dto.setCreated(entity.getCreated());

        ICompany company = entity.getCompany();

        if (company != null) {
            dto.setCompanyName(company.getName());

            ICity city = entity.getCity();
            dto.setCityId(city.getId());

            /*ICountry country = city.getCountry();
            dto.setCountryId(country.getId());

            IRegion region = country.getRegion();
            dto.setRegionId(region.getId());*/
        }
        return dto;
    }
}
