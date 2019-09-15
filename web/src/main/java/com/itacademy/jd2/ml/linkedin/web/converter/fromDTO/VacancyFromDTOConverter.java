package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VacancyFromDTOConverter implements Function<VacancyDTO, IVacancy> {
    
    private IVacancyService vacancyService;
    private ICityService cityService;

    @Autowired
    public VacancyFromDTOConverter(IVacancyService vacancyService, ICityService cityService) {
        this.vacancyService = vacancyService;
        this.cityService = cityService;
    }

    @Override
    public IVacancy apply(final VacancyDTO dto) {
        IVacancy entity = vacancyService.createEntity();
        entity.setId(dto.getId());
        entity.setJobTitle(dto.getJobTitle());
        entity.setAddress(dto.getAddress());
        entity.setContactInfo(dto.getContactInfo());
        entity.setDescription(dto.getDescription());
        entity.setCreated(dto.getCreated());

        ICity city = cityService.createEntity();
        city.setId(dto.getCityId());
        entity.setCity(city);

        return entity;
    }
    
}
