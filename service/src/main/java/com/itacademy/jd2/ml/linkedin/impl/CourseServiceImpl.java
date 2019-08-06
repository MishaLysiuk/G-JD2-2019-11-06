package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICourseDao;
import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private ICourseDao dao;

    @Autowired
    public CourseServiceImpl(ICourseDao dao) {
        this.dao = dao;
    }

    @Override
    public ICourse createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ICourse entity) {
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
    public ICourse get(final Integer id) {
        final ICourse entity = dao.get(id);
        return entity;
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public List<ICourse> getAll() {
        final List<ICourse> all = dao.selectAll();
        return all;
    }

    @Override
    public List<ICourse> find(final CourseFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(final CourseFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public ICourse getFullInfo(final Integer id) {
        final ICourse entity = dao.getFullInfo(id);
        return entity;
    }


}
