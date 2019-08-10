package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IEducationDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Education;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EducationDaoImpl extends AbstractDaoImpl<IEducation, Integer> implements IEducationDao {
    protected EducationDaoImpl() {
        super(Education.class);
    }

    @Override
    public List<IEducation> find(EducationFilter filter) {
        return null;
    }

    @Override
    public IEducation createEntity() {
        Education education = new Education();
        return education;
    }
}
