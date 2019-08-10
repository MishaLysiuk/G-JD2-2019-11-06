package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;

import java.util.List;

public interface IEducationService {
    IEducation createEntity();

    void save(IEducation entity);

    IEducation get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IEducation> getAll();

    List<IEducation> find(EducationFilter filter);
}
