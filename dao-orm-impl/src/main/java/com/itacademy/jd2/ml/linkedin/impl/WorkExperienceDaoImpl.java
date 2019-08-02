package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IWorkExperienceDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.WorkExperience;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkExperienceDaoImpl extends AbstractDaoImpl<IWorkExperience,Integer> implements IWorkExperienceDao {
    protected WorkExperienceDaoImpl() {
        super(WorkExperience.class);
    }

    @Override
    public List<IWorkExperience> find(WorkExperienceFilter filter) {
        return null;
    }

    @Override
    public IWorkExperience createEntity() {
        WorkExperience workExperience = new WorkExperience();
        return workExperience;
    }
}
