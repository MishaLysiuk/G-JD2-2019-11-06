package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.IDegreeService;
import com.itacademy.jd2.ml.linkedin.IEducationService;
import com.itacademy.jd2.ml.linkedin.ISpecialityService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EducationFromDTOConverter implements Function<EducationDTO, IEducation> {

    private IEducationService educationService;
    private ISpecialityService specialityService;
    private IDegreeService degreeService;
    private ICityService cityService;

    @Autowired
    public EducationFromDTOConverter(IEducationService educationService, ISpecialityService specialityService, IDegreeService degreeService, ICityService cityService) {
        this.educationService = educationService;
        this.specialityService = specialityService;
        this.degreeService = degreeService;
        this.cityService = cityService;
    }

    @Override
    public IEducation apply(final EducationDTO dto) {
        final IEducation entity = educationService.createEntity();

        entity.setId(dto.getId());
        entity.setUniversity(dto.getUniversity());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

        ISpeciality speciality = specialityService.createEntity();
        speciality.setId(dto.getSpecialityId());
        entity.setSpeciality(speciality);

        IDegree degree = degreeService.createEntity();
        degree.setId(dto.getSpecialityId());
        entity.setDegree(degree);

        entity.setAddress(dto.getAddress());

        ICity city = cityService.createEntity();
        city.setId(dto.getCityId());
        entity.setCity(city);

        return entity;
    }
}
