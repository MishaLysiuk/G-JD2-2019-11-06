package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IDegreeDao;
import com.itacademy.jd2.ml.linkedin.IDegreeService;
import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.filter.DegreeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DegreeServiceImpl implements IDegreeService {

    private IDegreeDao dao;

    @Autowired
    public DegreeServiceImpl(IDegreeDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IDegree createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IDegree entity) {
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
    public IDegree get(final Integer id) {
        final IDegree entity = dao.get(id);
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
    public List<IDegree> getAll() {
        final List<IDegree> all = dao.selectAll();
        return all;
    }



    @Override
    public List<IDegree> find(DegreeFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(DegreeFilter filter) {
        return dao.getCount(filter);
    }
}
