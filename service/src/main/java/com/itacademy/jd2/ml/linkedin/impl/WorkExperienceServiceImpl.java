package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IWorkExperienceDao;
import com.itacademy.jd2.ml.linkedin.IWorkExperienceService;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkExperienceServiceImpl implements IWorkExperienceService {

    private IWorkExperienceDao dao;

    @Autowired
    public WorkExperienceServiceImpl(IWorkExperienceDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IWorkExperience createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IWorkExperience entity) {
        final Date modifedOn = new Date();
        entity.setUpdated(modifedOn);
        if (entity.getId() == null) {
            entity.setCreated(modifedOn);
            dao.insert(entity);
        } else {
            dao.update(entity);
        }
    }


    @Override
    public IWorkExperience get(final Integer id) {
        final IWorkExperience entity = dao.get(id);
        return entity;
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<IWorkExperience> getAll() {
        final List<IWorkExperience> all = dao.selectAll();
        return all;
    }

    @Override
    public List<IWorkExperience> find(WorkExperienceFilter filter) {
        return dao.find(filter);
    }

    @Override
    public IWorkExperience getFullInfo(Integer id) {
        final IWorkExperience entity = dao.getFullInfo(id);
        return entity;
    }

}
