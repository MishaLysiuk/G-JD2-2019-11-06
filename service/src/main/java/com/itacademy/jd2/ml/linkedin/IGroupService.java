package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IGroupService {
    IGroup createEntity();

    @Transactional
    void save(IGroup entity);

    IGroup get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IGroup> getAll();

    List<IGroup> find(GroupFilter filter);

    long getCount(GroupFilter filter);
}
