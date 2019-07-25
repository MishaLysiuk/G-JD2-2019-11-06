package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;

import java.util.List;

public interface IGroupService {
    IGroup createEntity();

    void save(IGroup entity);

    IGroup get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IGroup> getAll();

    List<IGroup> find(GroupFilter filter);

    long getCount(GroupFilter filter);
}
