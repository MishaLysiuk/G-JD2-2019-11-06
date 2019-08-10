package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserLanguageDao;
import com.itacademy.jd2.ml.linkedin.IUserLanguageService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLanguageServiceImpl implements IUserLanguageService {

    private IUserLanguageDao dao;

    @Autowired
    public UserLanguageServiceImpl(IUserLanguageDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IUserLanguage createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IUserLanguage entity) {
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
    public IUserLanguage get(final Integer id) {
        final IUserLanguage entity = dao.get(id);
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
    public List<IUserLanguage> getAll() {
        final List<IUserLanguage> all = dao.selectAll();
        return all;
    }


    @Override
    public List<IUserLanguage> find(UserLanguageFilter filter) {
        return dao.find(filter);
    }

}
