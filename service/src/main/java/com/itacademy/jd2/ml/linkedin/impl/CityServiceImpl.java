package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICityDao;
import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    private ICityDao dao;

    @Autowired
    public CityServiceImpl(ICityDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ICity createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ICity entity) {
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
    public List<ICountry> findCountryByRegionId(Integer regionId){
        List<ICountry> countries = findCountryByRegionId(regionId);
        return countries;
    }

    @Override
    public List<ICity> findCityByCountryId(Integer countryId){
        List<ICity> cities = findCityByCountryId(countryId);
        return cities;
    }

    @Override
    public ICity get(final Integer id) {
        final ICity entity = dao.get(id);
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
    public List<ICity> getAll() {
        final List<ICity> all = dao.selectAll();
        return all;
    }


    @Override
    public List<ICity> find(CityFilter filter) {
        return dao.find(filter);
    }


}
