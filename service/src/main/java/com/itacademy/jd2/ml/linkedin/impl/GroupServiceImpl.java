package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IGroupDao;
import com.itacademy.jd2.ml.linkedin.IGroupService;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    
    private IGroupDao dao;

    @Autowired
    public GroupServiceImpl(IGroupDao dao) {
        this.dao = dao;
    }

    @Override
    public IGroup createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IGroup entity) {
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
    public IGroup get(final Integer id) {
        final IGroup entity = dao.get(id);
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
    public List<IGroup> getAll() {
        final List<IGroup> all = dao.selectAll();
        return all;
    }



    @Override
    public List<IGroup> find(GroupFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(GroupFilter filter) {
        return dao.getCount(filter);
    }
    
}
