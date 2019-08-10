package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICountryDao;
import com.itacademy.jd2.ml.linkedin.ICountryService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CountryFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private ICountryDao dao;

    @Autowired
    public CountryServiceImpl(ICountryDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ICountry createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ICountry entity) {
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
    public ICountry get(final Integer id) {
        final ICountry entity = dao.get(id);
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
    public List<ICountry> getAll() {
        final List<ICountry> all = dao.selectAll();
        return all;
    }

    @Override
    public List<ICountry> find(CountryFilter filter) {
        return dao.find(filter);
    }

}
