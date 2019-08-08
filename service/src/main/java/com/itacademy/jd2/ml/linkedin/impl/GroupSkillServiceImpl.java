package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IGroupSkillDao;
import com.itacademy.jd2.ml.linkedin.IGroupSkillService;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupSkillServiceImpl implements IGroupSkillService {
    
    private IGroupSkillDao dao;

    @Autowired
    public GroupSkillServiceImpl(IGroupSkillDao dao) {
        this.dao = dao;
    }

    @Override
    public IGroupSkill createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IGroupSkill entity) {
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
    public IGroupSkill get(final Integer id) {
        final IGroupSkill entity = dao.get(id);
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
    public List<IGroupSkill> getAll() {
        final List<IGroupSkill> all = dao.selectAll();
        return all;
    }



    @Override
    public List<IGroupSkill> find(GroupFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(GroupFilter filter) {
        return dao.getCount(filter);
    }

}
