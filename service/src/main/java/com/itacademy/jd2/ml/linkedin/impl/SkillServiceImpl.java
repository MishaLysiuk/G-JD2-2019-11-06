package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ISkillDao;
import com.itacademy.jd2.ml.linkedin.ISkillService;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SkillServiceImpl implements ISkillService {
    
    private ISkillDao dao;

    @Autowired
    public SkillServiceImpl(ISkillDao dao) {
        this.dao = dao;
    }

    @Override
    public ISkill createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ISkill entity) {
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
    public ISkill get(final Integer id) {
        final ISkill entity = dao.get(id);
        return entity;
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public List<ISkill> getAll() {
        final List<ISkill> all = dao.selectAll();
        return all;
    }

    @Override
    public long getCount(final SkillFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public ISkill getFullInfo(Integer id) {
        return dao.getFullInfo(id);
    }
}
