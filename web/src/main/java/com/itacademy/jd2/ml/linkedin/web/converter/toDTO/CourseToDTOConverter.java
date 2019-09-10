package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CourseToDTOConverter implements Function<ICourse, CourseDTO> {

    @Override
    public CourseDTO apply(ICourse entity) {
        final CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        ICompany company = entity.getCompany();
        dto.setCompanyName(company.getName());

        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setFinalResult(entity.getFinalResult());
        return dto;
    }
}
