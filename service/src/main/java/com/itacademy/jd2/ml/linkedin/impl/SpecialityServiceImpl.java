package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ISpecialityDao;
import com.itacademy.jd2.ml.linkedin.ISpecialityService;
import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.filter.SpecialityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpecialityServiceImpl implements ISpecialityService {

    private ISpecialityDao dao;

    @Autowired
    public SpecialityServiceImpl(ISpecialityDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ISpeciality createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ISpeciality entity) {
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
    public ISpeciality get(final Integer id) {
        final ISpeciality entity = dao.get(id);
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
    public List<ISpeciality> getAll() {
        final List<ISpeciality> all = dao.selectAll();
        return all;
    }



    @Override
    public List<ISpeciality> find(SpecialityFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(SpecialityFilter filter) {
        return dao.getCount(filter);
    }
}
