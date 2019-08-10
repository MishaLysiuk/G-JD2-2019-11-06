package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IAddressDao;
import com.itacademy.jd2.ml.linkedin.IAddressService;
import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.filter.AddressFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private IAddressDao dao;

    @Autowired
    public AddressServiceImpl(IAddressDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IAddress createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IAddress entity) {
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
    public IAddress get(final Integer id) {
        final IAddress entity = dao.get(id);
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
    public List<IAddress> getAll() {
        final List<IAddress> all = dao.selectAll();
        return all;
    }


    @Override
    public List<IAddress> find(AddressFilter filter) {
        return dao.find(filter);
    }

}
