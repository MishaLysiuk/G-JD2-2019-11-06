package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.IEducationService;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class EducationFromDTOConverter implements Function<EducationDTO, IEducation> {

    private IEducationService educationService;

    @Autowired
    public EducationFromDTOConverter(IEducationService educationService) {
        this.educationService = educationService;
    }



    @Override
    public IEducation apply(final EducationDTO dto) {
        final IEducation entity = educationService.createEntity();

        return entity;
    }
}
