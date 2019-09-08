package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IEducationDao;
import com.itacademy.jd2.ml.linkedin.IEducationService;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {
    
    private IEducationDao dao;

    @Autowired
    public EducationServiceImpl(IEducationDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IEducation createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IEducation entity) {
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
    public IEducation get(final Integer id) {
        final IEducation entity = dao.get(id);
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
    public List<IEducation> getAll() {
        final List<IEducation> all = dao.selectAll();
        return all;
    }

    @Override
    public List<IEducation> find(EducationFilter filter) {
        return dao.find(filter);
    }

    @Override
    public IEducation getFullInfo(final Integer id) {
        final IEducation entity = dao.getFullInfo(id);
        return entity;
    }
}
