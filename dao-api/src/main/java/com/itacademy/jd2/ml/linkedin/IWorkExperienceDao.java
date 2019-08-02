package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;

import java.util.List;

public interface IWorkExperienceDao extends IDao<IWorkExperience, Integer> {

    List<IWorkExperience> find(WorkExperienceFilter filter);

}
