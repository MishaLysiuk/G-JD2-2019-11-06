package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CourseFromDTOConverter implements Function<CourseDTO, ICourse> {

    private ICourseService courseService;

    @Autowired
    public CourseFromDTOConverter(ICourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ICourse apply(final CourseDTO dto) {
        final ICourse entity = courseService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setFinalResult(dto.getFinalResult());

        return entity;
    }
}
