package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ILanguageDao;
import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.filter.LanguageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService {
    
    private ILanguageDao dao;

    @Autowired
    public LanguageServiceImpl(ILanguageDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ILanguage createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ILanguage entity) {
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
    public ILanguage get(final Integer id) {
        final ILanguage entity = dao.get(id);
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
    public List<ILanguage> getAll() {
        final List<ILanguage> all = dao.selectAll();
        return all;
    }

    @Override
    public List<ILanguage> find(LanguageFilter filter) {
        return dao.find(filter);
    }
    
}
