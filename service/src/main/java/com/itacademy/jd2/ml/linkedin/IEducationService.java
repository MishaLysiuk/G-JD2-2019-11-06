package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IEducationService {
    IEducation createEntity();

    @Transactional
    void save(IEducation entity);

    IEducation get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IEducation> getAll();

    List<IEducation> find(EducationFilter filter);
}
