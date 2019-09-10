package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CourseFromDTOConverter implements Function<CourseDTO, ICourse> {

    private ICourseService courseService;
    private ICompanyService companyService;

    @Autowired
    public CourseFromDTOConverter(ICourseService courseService, ICompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @Override
    public ICourse apply(final CourseDTO dto) {
        final ICourse entity = courseService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        ICompany company = companyService.findByName(dto.getCompanyName()).get(0);
        if (company == null){
            companyService.save(company);
            entity.setCompany(company);
        }else entity.setCompany(company);

        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setFinalResult(dto.getFinalResult());

        return entity;
    }
}
