package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ILanguageLevelDao;
import com.itacademy.jd2.ml.linkedin.ILanguageLevelService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.filter.LanguageLevelFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LanguageLevelServiceImpl implements ILanguageLevelService {
    
    private ILanguageLevelDao dao;

    @Autowired
    public LanguageLevelServiceImpl(ILanguageLevelDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ILanguageLevel createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ILanguageLevel entity) {
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
    public ILanguageLevel get(final Integer id) {
        final ILanguageLevel entity = dao.get(id);
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
    public List<ILanguageLevel> getAll() {
        final List<ILanguageLevel> all = dao.selectAll();
        return all;
    }

    @Override
    public List<ILanguageLevel> find(LanguageLevelFilter filter) {
        return dao.find(filter);
    }
    
}
