package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;

import java.util.List;

public interface IEducationDao extends IDao<IEducation, Integer> {

    List<IEducation> find(EducationFilter filter);

    List<IEducation> findByUserId(Integer userId);

    IEducation getFullInfo(Integer id);
}
