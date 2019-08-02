package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserAccountDao;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    private IUserAccountDao dao;

    @Autowired
    public UserAccountServiceImpl(IUserAccountDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IUserAccount createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IUserAccount entity) {
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
    public IUserAccount get(final Integer id) {
        final IUserAccount entity = dao.get(id);
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
    public List<IUserAccount> getAll() {
        final List<IUserAccount> all = dao.selectAll();
        return all;
    }


    @Override
    public List<IUserAccount> find(UserAccountFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(UserAccountFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public IUserAccount findByEmail(String email){
        final IUserAccount entity = dao.findByEmail(email);
        return entity;
    }

}

