package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;

import java.util.List;

public interface IWorkExperienceService {
    IWorkExperience createEntity();

    void save(IWorkExperience entity);

    IWorkExperience get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IWorkExperience> getAll();

    List<IWorkExperience> find(WorkExperienceFilter filter);
}
