package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IWorkExperienceService {
    IWorkExperience createEntity();

    @Transactional
    void save(IWorkExperience entity);

    IWorkExperience get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IWorkExperience> getAll();

    List<IWorkExperience> find(WorkExperienceFilter filter);
}
