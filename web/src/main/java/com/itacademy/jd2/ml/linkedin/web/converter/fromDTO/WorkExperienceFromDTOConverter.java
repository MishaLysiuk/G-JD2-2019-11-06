package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.IWorkExperienceService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.web.dto.WorkExperienceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class WorkExperienceFromDTOConverter implements Function<WorkExperienceDTO, IWorkExperience> {

    private IWorkExperienceService workExperienceService;
    private ICityService cityService;
    private ICompanyService companyService;

    @Autowired
    public WorkExperienceFromDTOConverter(IWorkExperienceService workExperienceService, ICityService cityService, ICompanyService companyService) {
        this.workExperienceService = workExperienceService;
        this.cityService = cityService;
        this.companyService = companyService;
    }

    @Override
    public IWorkExperience apply(WorkExperienceDTO dto) {

        IWorkExperience entity = workExperienceService.createEntity();
        entity.setId(dto.getId());
        entity.setJobTitle(dto.getJobTitle());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setAddress(dto.getAddress());

        ICity city = cityService.createEntity();
        city.setId(dto.getCityId());
        entity.setCity(city);

        ICompany company = companyService.findByName(dto.getCompanyName()).get(0);
        if (company == null){
            companyService.save(company);
            entity.setCompany(company);
        }else entity.setCompany(company);

        return entity;
    }
}
