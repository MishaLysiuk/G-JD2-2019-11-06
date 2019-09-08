package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EducationToDTOConverter implements Function<IEducation, EducationDTO> {


    @Override
    public EducationDTO apply(IEducation entity) {
        final EducationDTO dto = new EducationDTO();

        return dto;
    }
}
