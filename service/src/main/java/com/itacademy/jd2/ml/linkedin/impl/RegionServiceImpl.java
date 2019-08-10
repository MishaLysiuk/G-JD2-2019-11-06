package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IRegionDao;
import com.itacademy.jd2.ml.linkedin.IRegionService;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.RegionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    private IRegionDao dao;

    @Autowired
    public RegionServiceImpl(IRegionDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IRegion createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IRegion entity) {
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
    public IRegion get(final Integer id) {
        final IRegion entity = dao.get(id);
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
    public List<IRegion> getAll() {
        final List<IRegion> all = dao.selectAll();
        return all;
    }

    @Override
    public List<IRegion> find(RegionFilter filter) {
        return dao.find(filter);
    }


}
